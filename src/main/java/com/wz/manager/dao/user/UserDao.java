package com.wz.manager.dao.user;

import org.springframework.stereotype.Repository;

import com.wz.manager.dao.BaseDao;
import com.wz.manager.domain.user.User;

@Repository
public class UserDao extends BaseDao<User> {
    
    public void saveUser(User user) {
        duplicateSave(user);
    }
}
