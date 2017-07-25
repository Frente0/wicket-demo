/**
 * 
 */
package com.ceeety.admin.module.common.ui;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月12日
 */
public class ModuleListener implements ServletRequestListener {
    
    private static final Logger LOG = LoggerFactory.getLogger(ModuleListener.class);
    
    public void requestInitialized(final ServletRequestEvent sre) {
        LOG.info("ModuleListener Request initialized from ip: " + sre.getServletRequest().getRemoteAddr());
    }

    public void requestDestroyed(final ServletRequestEvent sre) {
        LOG.info("ModuleListener Request destroyed from ip:" + sre.getServletRequest().getRemoteAddr());
    }

}
