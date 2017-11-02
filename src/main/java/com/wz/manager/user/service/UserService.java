package com.wz.manager.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wz.manager.user.dao.UserDao;
import com.wz.manager.user.domain.User;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public void saveUser(User user) {
        userDao.duplicateSave(user);
    }
}
