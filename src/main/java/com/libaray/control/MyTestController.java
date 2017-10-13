package com.libaray.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libaray.service.MyTestService;

@Controller
public class MyTestController {

    @Autowired
    private MyTestService myTestservice;
    
    @RequestMapping("/sql/test")
    public void sqlTest() {
        myTestservice.sqlTest();
    }
}