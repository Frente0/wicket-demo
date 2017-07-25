/**
 * 
 */
package com.ceeety.admin.module.common.panel;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * TopPanel
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class TopPanel extends Panel {
    
    private static final long serialVersionUID = -6113027444198572089L;

    public TopPanel(String id) {
        super(id);
        setRenderBodyOnly(true);
    }
}
