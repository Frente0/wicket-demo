/**
 * 
 */
package com.ceeety.admin.module.device.persistence;

import com.ceeety.admin.module.device.model.Relation;
import com.ceeety.admin.module.device.service.RelationService;
import com.ceeety.common.service.impl.BaseServiceImpl;

/**
 * 设备与分组关联服务接口实现
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class RelationServiceImpl extends BaseServiceImpl<Relation, Long> implements RelationService {
    
    private String moduleName = "设备与分组关联服务接口实现";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<Relation> getEntityClass() {
        return Relation.class;
    }
    
    @Override
    public String getModuleName() {
        return this.moduleName;
    }

}
