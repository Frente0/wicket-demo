/**
 * 
 */
package com.ceeety.admin.module.common;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.ceeety.admin.module.common.panel.BreadCrumbPanel;
import com.ceeety.admin.module.common.panel.FooterPanel;
import com.ceeety.admin.module.common.panel.HeaderPanel;
import com.ceeety.admin.module.common.panel.LeftPanel;
import com.ceeety.admin.module.common.panel.ModalPanel;
import com.ceeety.admin.module.common.panel.TopPanel;

/**
 * CeeetyAdminLayout
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class LayoutPage extends WebPage {

    private static final long serialVersionUID = -5419930087170946516L;
    
    protected MarkupContainer headerPanel;
    protected MarkupContainer topPanel;
    protected MarkupContainer leftPanel;
    protected MarkupContainer breadCrumbPanel;
    protected MarkupContainer footerPanel;
    protected MarkupContainer modalPanel;
    
    public LayoutPage() {
        super();
    }
    
    public LayoutPage(IModel<?> model){
        super(model);
    }

    public LayoutPage(PageParameters parameters){
        super(parameters);
    }
    
    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(headerPanel = new HeaderPanel("headerPanel"));
        add(topPanel = new TopPanel("topPanel"));
        add(leftPanel = new LeftPanel("leftPanel"));
        add(breadCrumbPanel = new BreadCrumbPanel("breadCrumbPanel"));
        add(footerPanel = new FooterPanel("footerPanel"));
        add(modalPanel = new ModalPanel("modalPanel"));
        topPanel.add(new Label("loginName", "admin"));
        leftPanel.add(new Label("loginName", "admin"));
        breadCrumbPanel.add(new Label("pageTitle", ((ModuleApplication) ModuleApplication.get()).getModuleApplicationName()));
        breadCrumbPanel.add(new Label("activeTitle", ((ModuleApplication) ModuleApplication.get()).getModuleApplicationName()));
    }
    
    public Component getHeaderPanel() {
        return headerPanel;
    }

    public Component getTopPanel() {
        return topPanel;
    }

    public Component getLeftPanel() {
        return leftPanel;
    }

    public Component getBreadCrumbPanel() {
        return breadCrumbPanel;
    }

    public Component getFooterPanel() {
        return footerPanel;
    }

    public Component getModalPanel() {
        return modalPanel;
    }
}
