package com.zj.springboothibernate.controller;


import com.zj.springboothibernate.config.HibernateProperties;
import com.zj.springboothibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    private UserService userService;




    @GetMapping("/test")
    public void test(){
//        userService.insertUser();
        userService.inserPctUser();
    }

    @GetMapping("/get")
    public void get(){
//        userService.insertUser();
        userService.get();
    }



}
