package com.zj.springboothibernate.entity;


import com.zj.springboothibernate.dao.BaseDao;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zj_user")

public class User extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long uid;
    @Column(name = "account")
    private String account;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "real_name")
    private String realName;
}
