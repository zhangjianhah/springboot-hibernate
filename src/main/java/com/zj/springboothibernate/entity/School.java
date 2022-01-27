package com.zj.springboothibernate.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "zj_school")
public class School {

    /**
     * 这里为主键配置生成策略为uuid
     * 因为jpa原生没有UUID这一策略，所以要用@GenericGenerator中UUID的策略，配置名称后引入到@GeneratedValue中
     *
     */
    @Id
    @GeneratedValue(generator = "myuuid")
    @GenericGenerator(name = "myuuid", strategy = "uuid")
    private String id;



    @Basic(fetch = FetchType.EAGER,optional = true)
    @Column
    private String name;




}
