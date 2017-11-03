package com.wz.manager.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wz.manager.dao.user.UserDao;
import com.wz.manager.domain.user.User;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public void saveUser(User user) {
        userDao.duplicateSave(user);
    }
}
