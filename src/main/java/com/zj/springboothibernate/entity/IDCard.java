package com.zj.springboothibernate.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * 身份证
 */
@Data
@Entity
@Table(name = "zj_id_card")
public class IDCard {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 32,unique = true)
    private String number;

    @OneToOne(cascade = {CascadeType.ALL},mappedBy = "idCard",fetch = FetchType.LAZY)
    private Student student;




}
