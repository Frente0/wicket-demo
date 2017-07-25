/**
 * 
 */
package com.ceeety.admin.module.device.model;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ceeety.common.service.Base;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 设备基本信息
 * @author Zhiyi-Bai
 * @date 2017年7月19日
 */
@XmlType
@XmlRootElement
@DatabaseTable(tableName="cty_device")
public class Device extends Base {
    
    private static final long serialVersionUID = 9144898198416621876L;
    
    //ID
    @DatabaseField(generatedId = true)  
    private Long id;
    
    //所属机场编码
    @DatabaseField(uniqueCombo = true)
    private String airportCode;
    
    //设备ID
    @DatabaseField(uniqueCombo = true)
    private String deviceId;
    
    //设备名称
    @DatabaseField
    private String name;
    
    //安装位置
    @DatabaseField
    private String location;
    
    //设备密锁
    @DatabaseField
    private String secret;
    
    //硬件详细编码
    @DatabaseField(unique = true)
    private String code;
    
    //设备类型
    @DatabaseField(foreign = true, maxForeignAutoRefreshLevel = 1, foreignAutoRefresh = true, canBeNull = false, uniqueCombo = true) 
    private DeviceType deviceType;
    
    //所属逻辑分组
    @ForeignCollectionField(eager = true, maxEagerLevel = 1)
    private Collection<Relation> relations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Collection<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Collection<Relation> relations) {
        this.relations = relations;
    }
}
