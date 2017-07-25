/**
 * 
 */
package com.ceeety.admin.module.common.panel;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * BreadCrumbPanel
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class BreadCrumbPanel extends Panel {

    private static final long serialVersionUID = 2718128723660369802L;
    
    public BreadCrumbPanel(String id) {
        super(id);
        setRenderBodyOnly(true);
    }
}
