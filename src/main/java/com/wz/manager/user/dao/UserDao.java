package com.wz.manager.user.dao;

import org.springframework.stereotype.Repository;

import com.wz.manager.dao.BaseDao;
import com.wz.manager.user.domain.User;

@Repository
public class UserDao extends BaseDao<User> {
    
    public void saveUser(User user) {
        duplicateSave(user);
    }
}
