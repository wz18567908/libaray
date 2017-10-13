package com.libaray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libaray.dao.MyTestDao;

@Service
public class MyTestService {

    @Autowired
    private MyTestDao myTestDao;
    
    public void sqlTest() {
        myTestDao.sqlTest();
    }
}
