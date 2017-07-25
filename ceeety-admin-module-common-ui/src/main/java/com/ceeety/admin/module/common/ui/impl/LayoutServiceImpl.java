/**
 * 
 */
package com.ceeety.admin.module.common.ui.impl;

import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

import com.ceeety.admin.module.common.ui.LayoutService;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月16日
 */
public class LayoutServiceImpl implements LayoutService {
    
    public void init(){
        Properties properties = new Properties();
        properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        Velocity.init(properties);
    }
    
    @Override
    public Template getLayoutTemlate() {
        return Velocity.getTemplate("/admin/layouts/main.html", "UTF-8");
    }
    
    @Override
    public Template getUpTemplate() {
        return Velocity.getTemplate("/admin/layouts/up.html", "UTF-8");
    }
    
    @Override
    public Template getDownTemplate() {
        return Velocity.getTemplate("/admin/layouts/down.html", "UTF-8");
    }

}
