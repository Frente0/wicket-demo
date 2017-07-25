/**
 * 
 */
package com.ceeety.admin.module.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月24日
 */
public class ModuleFilter implements Filter {
    
    private static final Logger LOG = LoggerFactory.getLogger(ModuleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("ModuleFilter....init....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOG.info("ModuleFilter....doFilter....");
    }

    @Override
    public void destroy() {
        LOG.info("ModuleFilter....destroy....");
    }

}
