package com.wz.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/test1", method= RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }
    
     @RequestMapping(value = "/toPage1.htmls")
     public ModelAndView toPage1() {
      return new ModelAndView("page1");
     }
}
