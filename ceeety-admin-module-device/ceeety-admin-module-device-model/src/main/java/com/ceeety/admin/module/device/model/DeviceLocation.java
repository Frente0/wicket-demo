/**
 * 
 */
package com.ceeety.admin.module.device.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ceeety.common.service.Base;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 设备安装位置固有信息
 * @author Zhiyi-Bai
 * @date 2017年7月21日
 */
@XmlType
@XmlRootElement
@DatabaseTable(tableName="cty_device_location")
public class DeviceLocation extends Base {

    private static final long serialVersionUID = 4198323431801953857L;
    
    //ID
    @DatabaseField(id = true)  
    private Long id;
    
    //登机口号
    @DatabaseField
    private String gate;
    
    //行李转盘号
    @DatabaseField
    private String belt;
    
    //设备周边信息
    @DatabaseField
    private String near;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getNear() {
        return near;
    }

    public void setNear(String near) {
        this.near = near;
    }

}
