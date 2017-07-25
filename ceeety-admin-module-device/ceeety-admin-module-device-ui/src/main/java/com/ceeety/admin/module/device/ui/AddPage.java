/**
 * 
 */
package com.ceeety.admin.module.device.ui;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.http.handler.RedirectRequestHandler;

import com.ceeety.admin.module.common.LayoutPage;
import com.ceeety.admin.module.common.custom.ChoiceRenderer;
import com.ceeety.admin.module.device.Application;
import com.ceeety.admin.module.device.model.Device;
import com.ceeety.admin.module.device.model.DeviceType;
import com.ceeety.admin.module.device.ui.panel.FormPanel;

/**
 * 新建页面
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class AddPage extends LayoutPage {

    private static final long serialVersionUID = 4629823216229189785L;
    
    private Device device;
    private FormPanel formPanel;
    
    public AddPage() {
        super();
        
        //添加表单
        Form<Device> form = new Form<Device>("deviceForm"){
            
            private static final long serialVersionUID = 8989366529783368420L;
            
            private DropDownChoice<DeviceType> dropDownChoice;
            
            @Override
            protected void onInitialize() {
                setMarkupId("form-release");
                device = new Device();
                setDefaultModel(new CompoundPropertyModel<Device>(device));
                formPanel = new FormPanel("formPanel");
                formPanel.add(new TextField<String>("airportCode"));
                formPanel.add(new TextField<String>("deviceId"));
                formPanel.add(new TextField<String>("name"));
                formPanel.add(new TextField<String>("location"));
                formPanel.add(new TextField<String>("code"));
                formPanel.add(new TextField<String>("secret"));
                List<DeviceType> deviceTypes = Application.get().getDeviceTypeService().queryForAll();
                ChoiceRenderer<DeviceType> deviceTypeRenderer = new ChoiceRenderer<DeviceType>("deviceTypeId,name", "id", "－");
                formPanel.add(dropDownChoice = new DropDownChoice<DeviceType>("deviceType.id", new Model<DeviceType>(), deviceTypes, deviceTypeRenderer));
                formPanel.add(new ExternalLink("cancelLink", getRequestCycle().urlFor(ListPage.class, null).toString()));
                add(formPanel);
                super.onInitialize();
            }

            @Override
            protected void onSubmit() {
                device.setDeviceType(dropDownChoice.getConvertedInput());
                Application.get().getDeviceService().create(device);
                IRequestHandler handler = new RedirectRequestHandler(getRequestCycle().urlFor(ListPage.class, null).toString());
                getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
            }
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
