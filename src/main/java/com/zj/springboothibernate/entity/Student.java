package com.zj.springboothibernate.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "zj_student")
public class Student {

    /**
     * TABLE：使用一个特定的数据库表格来保存主键。
     * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     * IDENTITY：主键由数据库自动生成（主要是自动增长型）
     * AUTO：主键由程序控制。
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Integer id;


    @Column
    private String name;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private IDCard idCard;


}
