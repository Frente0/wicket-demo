/**
 * 
 */
package com.ceeety.admin.module.common.custom;

import java.util.List;

import org.apache.wicket.core.util.lang.PropertyResolver;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.io.IClusterable;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月24日
 */
public class ChoiceRenderer<T> implements IChoiceRenderer<T>, IClusterable {
    
    private static final long serialVersionUID = 1L;

    /** expression for getting the display value. */
    private final String displayExpression;

    /** expression for getting the id. */
    private final String idExpression;
    
    private final String delimiter;

    /**
     * Constructor.
     * 
     * When you use this constructor, the display value will be determined by
     * calling toString() on the list object, and the id will be based on the
     * list index. the id value will be the index
     */
    public ChoiceRenderer() {
        this(null);
    }

    /**
     * Constructor.
     * 
     * When you use this constructor, the display value will be determined by
     * executing the given property expression on the list object, and the id
     * will be based on the list index. The display value will be calculated by
     * the given property expression
     * 
     * @param displayExpression
     *            A property expression to get the display value
     */
    public ChoiceRenderer(String displayExpression) {
        this(displayExpression, null);
    }

    /**
     * Constructor.
     * 
     * When you use this constructor, both the id and the display value will be
     * determined by executing the given property expressions on the list
     * object.
     * 
     * @param displayExpression
     *            A property expression to get the display value
     * @param idExpression
     *            A property expression to get the id value
     */
    public ChoiceRenderer(String displayExpression, String idExpression) {
        this.displayExpression = displayExpression;
        this.idExpression = idExpression;
        this.delimiter = "";
    }
    
    public ChoiceRenderer(String displayExpression, String idExpression, String delimiter) {
        this.displayExpression = displayExpression;
        this.idExpression = idExpression;
        this.delimiter = delimiter;
    }

    @Override
    public Object getDisplayValue(T object) {
        Object returnValue = object;
        if(displayExpression.contains(",")){
            returnValue = "";
            String[] strings = displayExpression.split(",");
            for(int i = 0; i < strings.length; i++){
                if(i < (strings.length-1)){
                    returnValue += (PropertyResolver.getValue(strings[i], object) + delimiter);
                }else{
                    returnValue += (PropertyResolver.getValue(strings[i], object)+"");
                }
            }
        }else if ((displayExpression != null) && (object != null)) {
            returnValue = PropertyResolver.getValue(displayExpression, object);
        }

        if (returnValue == null) {
            return "";
        }

        return returnValue;
    }

    @Override
    public String getIdValue(T object, int index) {
        if (idExpression == null) {
            return Integer.toString(index);
        }

        if (object == null) {
            return "";
        }

        Object returnValue = PropertyResolver.getValue(idExpression, object);
        if (returnValue == null) {
            return "";
        }

        return returnValue.toString();
    }

    @Override
    public T getObject(String id, IModel<? extends List<? extends T>> choices) {
        List<? extends T> _choices = choices.getObject();
        for (int index = 0; index < _choices.size(); index++) {
            // Get next choice
            final T choice = _choices.get(index);
            if (getIdValue(choice, index).equals(id)) {
                return choice;
            }
        }
        return null;
    }
}
