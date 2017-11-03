package com.wz.manager.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wz.manager.domain.user.User;
import com.wz.manager.service.audit.AdviceAuditLogger;
import com.wz.manager.service.audit.AuditLogger;
import com.wz.manager.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AdviceAuditLogger adviceAuditLogger;
    
    @RequestMapping(value = "/save", method= RequestMethod.GET)
    @AuditLogger()
    public void saveUser() {
        User user = new User();
        user.setUid(1);
        user.setUname("u1");
        user.setUpassword("111111");
        
        userService.saveUser(user);
        adviceAuditLogger.writeAuditLogger();
    }
}
