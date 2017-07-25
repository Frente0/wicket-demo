/**
 * 
 */
package com.ceeety.admin.module.common.panel;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * ModalPanel
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class ModalPanel extends Panel {
    
    private static final long serialVersionUID = 7342014787891194282L;

    public ModalPanel(String id) {
        super(id);
        setRenderBodyOnly(true);
    }

}
