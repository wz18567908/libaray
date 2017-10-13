package com.libaray.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class BaseDao<T extends Serializable> {
    private Class<T> entityClass;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("rawtypes")
    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    /*
     * SQL function part
     */
    public Query getSqlQuery(String sql) {
        return getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    }

    /*
     * HQL function part
     */
    public Query getQuery(String hql) {
        return getSession().createQuery(hql);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
