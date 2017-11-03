package com.wz.manager.service.audit;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wz.manager.dao.audit.AuditDao;
import com.wz.manager.domain.audit.Audit;

@Transactional
public class AdviceAuditLogger {

    @Autowired
    private AuditDao auditDao;

    public void writeAuditLogger() {
        
        Audit audit = new Audit();
        audit.setIp("192.168.0.6");
        Date currentDate = new Date();
        audit.setTime(currentDate);
        audit.setUserName("wz");
        
        auditDao.auditLog(audit);
    }
}
