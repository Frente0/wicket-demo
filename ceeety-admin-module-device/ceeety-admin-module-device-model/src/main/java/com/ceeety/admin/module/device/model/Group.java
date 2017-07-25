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
 * 设备分组信息
 * @author Zhiyi-Bai
 * @date 2017年7月21日
 */
@XmlType
@XmlRootElement
@DatabaseTable(tableName="cty_device_group")
public class Group extends Base {

    private static final long serialVersionUID = 5385133940955776980L;
    
    //ID
    @DatabaseField(generatedId = true)  
    private Long id;
    
    //分组编码
    @DatabaseField
    private String code;
    
    //分组中文名称
    @DatabaseField
    private String name;
    
    //分组描述
    @DatabaseField
    private String desc;
    
    //父分组
    @DatabaseField(foreign = true, maxForeignAutoRefreshLevel = 1, foreignAutoRefresh = true) 
    private Group parent;
    
    //子分组
    @ForeignCollectionField
    private Collection<Group> childs;
    
    //分组关联设备
    @ForeignCollectionField(eager = true, maxEagerLevel = 1)
    private Collection<Relation> relations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public Collection<Group> getChilds() {
        return childs;
    }

    public void setChilds(Collection<Group> childs) {
        this.childs = childs;
    }

    public Collection<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Collection<Relation> relations) {
        this.relations = relations;
    }

}
