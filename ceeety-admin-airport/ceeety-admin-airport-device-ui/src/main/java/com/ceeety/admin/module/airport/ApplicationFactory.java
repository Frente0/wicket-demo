/**
 * 
 */
package com.ceeety.admin.module.airport;

import java.util.Map;

import com.ceeety.admin.airport.device.service.AirportService;
import com.ceeety.admin.module.common.ModuleApplicationFactory;

/**
 * 
 * @author Qiao-Zhang
 * @Date
 */
public class ApplicationFactory extends ModuleApplicationFactory<Application> {
    
    private Map<String, Object> serviceMap;
    
    @Override
    public Class<Application> getWebApplicationClass() {
        return Application.class;
    }
    
    @Override
    public void onInstantiation(Application application) {
        application.setAirportService((AirportService) serviceMap.get("airportService"));
    }

    public Map<String, Object> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, Object> serviceMap) {
        this.serviceMap = serviceMap;
    }
    
}
