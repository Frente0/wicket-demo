package com.ceeety.admin.airport.device.persistence;
import com.ceeety.admin.airport.device.model.Airport;
import com.ceeety.admin.airport.device.service.AirportService;
import com.ceeety.common.service.impl.BaseServiceImpl;


public class AirportServiceImpl extends BaseServiceImpl<Airport, Long> implements AirportService{

private String moduleName = "airport";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<Airport> getEntityClass() {
        return Airport.class;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }

	

}
