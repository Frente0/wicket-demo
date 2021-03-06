/**
 * 
 */
package com.ceeety.admin.module.device.action;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.http.handler.RedirectRequestHandler;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.ceeety.admin.module.device.Application;
import com.ceeety.admin.module.device.ui.ListPage;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月25日
 */
public class DeleteAction extends WebPage {

    private static final long serialVersionUID = -6605551663773811232L;
    
    public DeleteAction(PageParameters parameters) {
        super(parameters);
        Application.get().getDeviceService().deleteById(parameters.get("id").toLong());
        IRequestHandler handler = new RedirectRequestHandler(getRequestCycle().urlFor(ListPage.class, null).toString());
        getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
    }

}
