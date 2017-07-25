/**
 * 
 */
package com.ceeety.admin.module.user.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ceeety.common.service.Base;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author Zhiyi-Bai
 * @date 2017年6月28日
 */
@XmlType
@XmlRootElement
@DatabaseTable(tableName="ceeety_test_user")
public class User extends Base implements Serializable {

    private static final long serialVersionUID = -9048279630597390125L;
    
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String username;
    @DatabaseField
    private String password;
    @DatabaseField
    private String salt;
    @DatabaseField
    private String ownerType;
    @DatabaseField
    private Integer ownerId;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getOwnerType() {
        return ownerType;
    }
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    public Integer getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
