/**
 * 
 */
package com.ceeety.admin.module.common.ui;

import org.apache.velocity.Template;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月16日
 */
public interface LayoutService {

    /**
     * 获取布局模板
     * @return
     */
    public Template getLayoutTemlate();
    
    /**
     * 获取上半部分模板
     * @return
     */
    public Template getUpTemplate();
    
    /**
     * 获取下半部分模板
     * @return
     */
    public Template getDownTemplate();
    
}
