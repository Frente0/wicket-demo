/**
 * 
 */
package com.ceeety.admin.module.common.panel;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * Header
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class HeaderPanel extends Panel {
    
    private static final long serialVersionUID = 7275452249600048466L;

    public HeaderPanel(String id) {
        super(id);
        setRenderBodyOnly(true);
    }

}
