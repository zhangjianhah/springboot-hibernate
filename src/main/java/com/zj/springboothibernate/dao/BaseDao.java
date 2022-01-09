package com.zj.springboothibernate.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.util.List;

public class BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private EntityManagerFactory entityManagerFactory;


    public Session getSession(){
//        return entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
        return sessionFactory.getCurrentSession();
    }


    public List findByHQL(String hql) {
        try {
            Query queryObject = getSession().createQuery(hql);
            return queryObject.list();
        } catch (RuntimeException re) {
//            log.error("findByHQL by property name failed", re);
            throw re;
        }
    }


    public <T> T getEntity(Class<T> entityName, Serializable id) {
//        getSession().flush();
//        getSession().clear();
        T t = getSession().get(entityName, id);
        if (t != null) {
            getSession().flush();
        }

        return t;
    }
}
