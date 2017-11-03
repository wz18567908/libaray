package com.wz.manager.dao.audit;

import org.springframework.stereotype.Repository;

import com.wz.manager.dao.BaseDao;
import com.wz.manager.domain.audit.Audit;

@Repository
public class AuditDao extends BaseDao<Audit> {

    public void auditLog(Audit audit) {
        duplicateSave(audit);
    }
}
