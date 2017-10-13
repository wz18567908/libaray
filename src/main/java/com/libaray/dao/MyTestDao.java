package com.libaray.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.libaray.domain.User;

@Repository
public class MyTestDao extends BaseDao<Serializable> {

    @Test
    public void sqlTest() {
        Configuration config = new Configuration();
        config.configure("/spring-dao.xml");
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        User user = new User();
        user.setUid(1);
        user.setUname("test");
        user.setPassword("111111");
        user.setRole(0);
        session.save(user);
        tr.commit();
        session.close();
        if (session != null) {
            System.out.println("Contection Success");
            session.close();
        } else {
            System.out.println("Contection Failed!");
        }
    }
}
