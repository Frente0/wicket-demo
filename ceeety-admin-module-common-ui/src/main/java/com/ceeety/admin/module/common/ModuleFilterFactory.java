/**
 * 
 */
package com.ceeety.admin.module.common;

import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.ServletException;

import org.ops4j.pax.wicket.api.ConfigurableFilterConfig;
import org.ops4j.pax.wicket.api.FilterFactory;

/**
 * 业务模块过滤器工厂
 * @author Zhiyi-Bai
 * @date 2017年7月24日
 */
public class ModuleFilterFactory implements FilterFactory {
    
    private Map<String, String> initParams;

    @Override
    public Filter createFilter(ConfigurableFilterConfig filterConfig) throws ServletException {
        filterConfig.putAllInitParameter(initParams);
        return new ModuleFilter();
    }
    
    public Map<String, String> getInitParams() {
        return initParams;
    }
    
    public void setInitParams(Map<String, String> initParams) {
        this.initParams = initParams;
    }

}
