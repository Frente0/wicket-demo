/**
 * 
 */
package com.ceeety.admin.module.airport.ui;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import com.ceeety.admin.airport.device.model.Airport;
import com.ceeety.admin.module.airport.Application;
import com.ceeety.admin.module.airport.panel.FormPanel;
import com.ceeety.admin.module.common.LayoutPage;
import com.ceeety.admin.module.common.custom.ChoiceRenderer;

/**
 * 新建页面
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class AddPage extends LayoutPage {

    private static final long serialVersionUID = 4629823216229189785L;
    
    private Airport airport;
    private FormPanel formPanel;
    
    public AddPage() {
        super();
        
        //添加表单
        Form<Airport> form = new Form<Airport>("deviceForm"){
            
            private static final long serialVersionUID = 8989366529783368420L;
            
            private DropDownChoice<Airport> dropDownChoice;
            
            @Override
            protected void onInitialize() {
                setMarkupId("form-release");
                airport = new Airport();
                setDefaultModel(new CompoundPropertyModel<Airport>(airport));
                formPanel = new FormPanel("formPanel");
                formPanel.add(new TextField<String>("airportCode"));
                formPanel.add(new TextField<String>("deviceId"));
                formPanel.add(new TextField<String>("name"));
                formPanel.add(new TextField<String>("location"));
                formPanel.add(new TextField<String>("code"));
                formPanel.add(new TextField<String>("secret"));
                List<Airport> deviceTypes = Application.get().getAirportService().queryForAll();
                ChoiceRenderer<Airport> deviceTypeRenderer = new ChoiceRenderer<Airport>("deviceTypeId,name", "id", "－");
                formPanel.add(dropDownChoice = new DropDownChoice<Airport>("deviceType.id", new Model<Airport>(), deviceTypes, deviceTypeRenderer));
                formPanel.add(new ExternalLink("cancelLink", getRequestCycle().urlFor(ListPage.class, null).toString()));
                add(formPanel);
                super.onInitialize();
            }

//            @Override
//            protected void onSubmit() {
//                airport.setCode_3(code_3);(dropDownChoice.getConvertedInput());
//                Application.get().getDeviceService().create(airport);
//                IRequestHandler handler = new RedirectRequestHandler(getRequestCycle().urlFor(ListPage.class, null).toString());
//                getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
//            }
        };
        add(form);
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        breadCrumbPanel.replace(new Label("pageTitle", "新建设备"));
        breadCrumbPanel.replace(new Label("activeTitle", "新建设备"));
    }

}
