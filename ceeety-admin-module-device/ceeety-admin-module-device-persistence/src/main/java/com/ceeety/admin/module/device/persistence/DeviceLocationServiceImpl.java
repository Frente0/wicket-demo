/**
 * 
 */
package com.ceeety.admin.module.device.persistence;

import com.ceeety.admin.module.device.model.DeviceLocation;
import com.ceeety.admin.module.device.service.DeviceLocationService;
import com.ceeety.common.service.impl.BaseServiceImpl;

/**
 * @author Zhiyi-Bai
 * @date 2017年7月21日
 */
public class DeviceLocationServiceImpl extends BaseServiceImpl<DeviceLocation, Long> implements DeviceLocationService {
    
    private String moduleName = "设备安装位置固有信息服务实现";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<DeviceLocation> getEntityClass() {
        return DeviceLocation.class;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }
    
}
