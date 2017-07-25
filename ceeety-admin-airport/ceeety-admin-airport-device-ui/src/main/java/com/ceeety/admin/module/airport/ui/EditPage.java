/**
 * 
 */
package com.ceeety.admin.module.airport.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.osgi.service.device.Device;

import com.ceeety.admin.airport.device.model.Airport;
import com.ceeety.admin.module.airport.panel.FormPanel;
import com.ceeety.admin.module.common.LayoutPage;

/**
 * 
 * @author Qiao-Zhang
 * @Date
 */
public class EditPage extends LayoutPage {

    private static final long serialVersionUID = 7236620574855819728L;
    
    private Airport device;
    private FormPanel formPanel;
    
    public EditPage(PageParameters parameters) {
        //添加表单
        Form<Device> form = new Form<Device>("deviceForm"){
            
            private static final long serialVersionUID = 8989366529783368420L;

        };
        add(form);
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        breadCrumbPanel.replace(new Label("pageTitle", "编辑设备"));
        breadCrumbPanel.replace(new Label("activeTitle", "编辑设备"));
    }
    
}
