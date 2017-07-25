/**
 * 
 */
package com.ceeety.admin.module.device;

import java.util.Map;

import com.ceeety.admin.module.common.ModuleApplicationFactory;
import com.ceeety.admin.module.device.service.DeviceLocationService;
import com.ceeety.admin.module.device.service.DeviceService;
import com.ceeety.admin.module.device.service.DeviceTypeService;
import com.ceeety.admin.module.device.service.GroupService;
import com.ceeety.admin.module.device.service.RelationService;

/**
 * 设备管理应用工厂
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class ApplicationFactory extends ModuleApplicationFactory<Application> {
    
    private Map<String, Object> serviceMap;
    
    @Override
    public Class<Application> getWebApplicationClass() {
        return Application.class;
    }
    
    @Override
    public void onInstantiation(Application application) {
        application.setDeviceService((DeviceService) serviceMap.get("deviceService"));
        application.setDeviceTypeService((DeviceTypeService) serviceMap.get("deviceTypeService"));
        application.setDeviceLocationService((DeviceLocationService) serviceMap.get("deviceLocationService"));
        application.setGroupService((GroupService) serviceMap.get("groupService"));
        application.setRelationService((RelationService) serviceMap.get("relationService"));
    }

    public Map<String, Object> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, Object> serviceMap) {
        this.serviceMap = serviceMap;
    }
    
}
