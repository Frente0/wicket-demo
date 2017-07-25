/**
 * 
 */
package com.ceeety.admin.module.airport.panel;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * 表单Panel
 * @author Zhiyi-Bai
 * @date 2017年7月24日
 */
public class FormPanel extends Panel {

    private static final long serialVersionUID = 2869834948677001L;

    public FormPanel(String id) {
        super(id);
    }
    
    public FormPanel(final String id, final IModel<?> model) {
        super(id, model);
    }

}
