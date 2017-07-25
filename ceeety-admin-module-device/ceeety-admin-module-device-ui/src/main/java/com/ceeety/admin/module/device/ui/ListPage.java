/**
 * 
 */
package com.ceeety.admin.module.device.ui;

import org.apache.wicket.markup.html.basic.Label;

import com.ceeety.admin.module.common.LayoutPage;

/**
 * 列表页面
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class ListPage extends LayoutPage {

    private static final long serialVersionUID = 7820094414252603068L;
    
    public ListPage() {
        super();
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        breadCrumbPanel.replace(new Label("pageTitle", "设备列表"));
        breadCrumbPanel.replace(new Label("activeTitle", "设备列表"));
    }

}
