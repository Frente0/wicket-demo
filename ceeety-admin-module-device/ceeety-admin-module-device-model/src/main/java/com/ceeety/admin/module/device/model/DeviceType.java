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
 * @author Zhiyi-Bai
 * @date 2017年7月21日
 */
@XmlType
@XmlRootElement
@DatabaseTable(tableName="cty_device_type")
public class DeviceType extends Base {

    private static final long serialVersionUID = -7819655405509521689L;
    
    //ID
    @DatabaseField(generatedId = true)  
    private Long id;
    
    //类型编码
    @DatabaseField(unique = true)
    private String deviceTypeId;
    
    //类型名称
    @DatabaseField
    private String name;
    
    //单面屏幕数量
    @DatabaseField
    private Integer screen;
    
    //1:单面, 2:双面, 3:三面, 4:四面
    @DatabaseField
    private Integer section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScreen() {
        return screen;
    }

    public void setScreen(Integer screen) {
        this.screen = screen;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }
}
