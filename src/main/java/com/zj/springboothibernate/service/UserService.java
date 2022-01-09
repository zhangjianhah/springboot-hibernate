package com.zj.springboothibernate.service;


import com.zj.springboothibernate.dao.UserDao;
import com.zj.springboothibernate.entity.PcUser;
import com.zj.springboothibernate.entity.Student;
import com.zj.springboothibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.SpringSessionContext;

@Transactional
@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public void insertUser() {
        User user = new User();
        user.setAccount("zj");
        user.setPwd("11");
        user.setRealName("zhangjian");

        userDao.getSession().save(user);

//        int a = 1/0;

        Student student = new Student();

        userDao.getSession().save(student);


    }


    public void inserPctUser() {
//        PcUser user = new PcUser();
//        user.setAccount("zj");
//        user.setPwd("11");
//        user.setRealName("zhangjian");
//        user.setText("1111");
//
//        userDao.getSession().save(user);


        userDao.getSession().createQuery("from PcUser").list();
        userDao.getSession().createQuery("from User ").list();



    }


    public void get() {
//        PcUser user = new PcUser();
//        user.setAccount("zj");
//        user.setPwd("11");
//        user.setRealName("zhangjian");
//        user.setText("1111");
//
//        userDao.getSession().save(user);



//        List from_user = userDao.getSession().createQuery("from User ").list();
//
//        List from_pcUser = userDao.getSession().createQuery("from PcUser").list();


//        PcUser pcUser = userDao.getEntity(PcUser.class,2L);
//        User user = userDao.getEntity(User.class,2L);


        User user = new User();
        user.setAccount("1");

        userDao.getSession().save(user);

        PcUser pcUser = new PcUser();

        pcUser.setUid(user.getUid());
        pcUser.setAccount(user.getAccount());
        pcUser.setText("119");

//        userDao.getSession().update(pcUser);
        userDao.getSession().merge(pcUser);

        System.out.println("");


//        getSession().flush();
////getSession().clear();
//
//        T t = getSession().get(entityName, id);
//        System.out.println(t);

    }

//    public List<User> listUser()  {
////        userDao.getSession().
//    }
}
