/**
 * 
 */
package com.ceeety.admin.module.user.persistence;

import com.ceeety.admin.module.user.model.User;
import com.ceeety.admin.module.user.service.UserService;
import com.ceeety.common.service.impl.BaseServiceImpl;

/**
 * 用户服务接口实现类
 * @author Zhiyi-Bai
 * @date 2017年6月28日
 */
public class UserServiceImpl extends BaseServiceImpl<User, Integer>  implements UserService {
    
    private String moduleName = "用户管理";
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public String getModuleName() {
        return this.moduleName;
    }
    
}
