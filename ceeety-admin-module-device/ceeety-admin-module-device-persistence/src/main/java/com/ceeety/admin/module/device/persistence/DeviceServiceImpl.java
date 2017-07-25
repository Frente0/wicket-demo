/**
 * 
 */
package com.ceeety.admin.module.device.persistence;

import com.ceeety.admin.module.device.model.Device;
import com.ceeety.admin.module.device.service.DeviceService;
import com.ceeety.common.service.impl.BaseServiceImpl;

/**
 * 设备服务接口实现类
 * @author Zhiyi-Bai
 * @date 2017年7月19日
 */
public class DeviceServiceImpl extends BaseServiceImpl<Device, Long> implements DeviceService {
    
    private String moduleName = "设备管理";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<Device> getEntityClass() {
        return Device.class;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }

}
