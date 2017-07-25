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
 * 设备与分组关联
 * @author Zhiyi-Bai
 * @date 2017年7月19日
 */
@XmlType
@XmlRootElement
@DatabaseTable(tableName="cty_relation_device_group")
public class Relation extends Base {

    private static final long serialVersionUID = -8815932074089403855L;
    
    //ID
    @DatabaseField(generatedId = true)  
    private Long id;
    
    //分组
    @DatabaseField(foreign = true, maxForeignAutoRefreshLevel = 1, foreignAutoRefresh = true, canBeNull = false, uniqueCombo = true) 
    private Group group;
    
    //设备
    @DatabaseField(foreign = true, maxForeignAutoRefreshLevel = 1, foreignAutoRefresh = true, canBeNull = false, uniqueCombo = true) 
    private Device device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
