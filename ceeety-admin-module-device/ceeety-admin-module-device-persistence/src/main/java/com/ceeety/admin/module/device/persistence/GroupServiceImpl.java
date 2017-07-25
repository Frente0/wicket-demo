/**
 * 
 */
package com.ceeety.admin.module.device.persistence;

import com.ceeety.admin.module.device.model.Group;
import com.ceeety.admin.module.device.service.GroupService;
import com.ceeety.common.service.impl.BaseServiceImpl;

/**
 * 设备分组信息服务接口实现
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class GroupServiceImpl extends BaseServiceImpl<Group, Long> implements GroupService {
    
    private String moduleName = "设备分组信息服务接口实现";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<Group> getEntityClass() {
        return Group.class;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }

}
