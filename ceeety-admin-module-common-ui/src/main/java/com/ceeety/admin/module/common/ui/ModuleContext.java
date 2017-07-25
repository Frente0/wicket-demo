/**
 * 
 */
package com.ceeety.admin.module.common.ui;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月12日
 */
public class ModuleContext implements HttpContext {
    
    private static final Logger LOG = LoggerFactory.getLogger(ModuleContext.class);

    public boolean handleSecurity(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        LOG.info("ModuleContext Forbiden access!");
        response.addHeader("WWW-Authenticate", "Basic realm=\"Test Realm\"");
        return false;
    }

    public URL getResource(final String name) {
        throw new IllegalStateException("This method should not be possible to be called as the access is denied");
    }

    public String getMimeType(String s) {
        throw new IllegalStateException("This method should not be possible to be called as the access is denied");
    }

}
