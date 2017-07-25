/**
 * 
 */
package com.ceeety.admin.module.airport.action;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.handler.TextRequestHandler;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.ceeety.admin.module.airport.Application;
import com.ceeety.admin.module.common.Page;

/**
 * 
 * @author Qiao-Zhang
 * @Date
 */
public class PageAction extends WebPage {

    private static final long serialVersionUID = -4106668105493968402L;
    
    public PageAction(PageParameters params){
        super(params);
        Page<?> page = Page.createDataTablePage(params);
        page.setTotal(Application.get().getAirportService().countOf());
        page.setData(Application.get().getAirportService().queryForPage(page.getOffset(), page.getMax()));
        IRequestHandler handler = new TextRequestHandler("application/json", "utf-8", page.toDataTableJson());
        getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
    }

}
