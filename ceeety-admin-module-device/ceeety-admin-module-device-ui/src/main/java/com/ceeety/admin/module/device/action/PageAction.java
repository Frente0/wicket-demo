/**
 * 
 */
package com.ceeety.admin.module.device.action;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.handler.TextRequestHandler;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.ceeety.admin.module.common.Page;
import com.ceeety.admin.module.device.Application;

/**
 * AJAX获取设备列表每页数据
 * @author Zhiyi-Bai
 * @date 2017年7月23日
 */
public class PageAction extends WebPage {

    private static final long serialVersionUID = -4106668105493968402L;
    
    public PageAction(PageParameters params){
        super(params);
        Page<?> page = Page.createDataTablePage(params);
        page.setTotal(Application.get().getDeviceService().countOf());
        page.setData(Application.get().getDeviceService().queryForPage(page.getOffset(), page.getMax()));
        IRequestHandler handler = new TextRequestHandler("application/json", "utf-8", page.toDataTableJson());
        getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
    }

}
