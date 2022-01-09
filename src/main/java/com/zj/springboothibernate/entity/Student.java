package com.zj.springboothibernate.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zj_student1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Integer id;
}
