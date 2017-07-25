/**
 * 
 */
package com.ceeety.admin.module.device.persistence;

import com.ceeety.admin.module.device.model.DeviceType;
import com.ceeety.admin.module.device.service.DeviceTypeService;
import com.ceeety.common.service.impl.BaseServiceImpl;

/**
 * 设备类型服务接口实现
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class DeviceTypeServiceImpl extends BaseServiceImpl<DeviceType, Long> implements DeviceTypeService {
    
    private String moduleName = "设备类型服务接口实现";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<DeviceType> getEntityClass() {
        return DeviceType.class;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }
    
}
