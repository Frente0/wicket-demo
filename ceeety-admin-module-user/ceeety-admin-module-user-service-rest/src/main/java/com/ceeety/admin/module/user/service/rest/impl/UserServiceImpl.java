package com.ceeety.admin.module.user.service.rest.impl;

import java.util.Collection;

import com.ceeety.admin.module.user.model.User;
import com.ceeety.admin.module.user.service.rest.UserService;

public class UserServiceImpl implements UserService {
    
    private com.ceeety.admin.module.user.service.UserService pUserService;
    
    public void setpUserService(com.ceeety.admin.module.user.service.UserService pUserService) {
        this.pUserService = pUserService;
    }

    @Override
    public Collection<User> getUsers(Integer offset, Integer limit) {
        if(null != offset && null != limit){
            return pUserService.queryForPage(offset.longValue(), limit.longValue());
        }else{
            return pUserService.queryForAll();
        }
    }

    @Override
    public User getUser(Integer id) {
        return pUserService.queryForId(id);
    }

    @Override
    public int addUser(User user) {
        return pUserService.create(user);
    }

    @Override
    public int updateUser(User user) {
        return pUserService.update(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return pUserService.deleteById(id);
    }
}
