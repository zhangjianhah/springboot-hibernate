package com.zj.springboothibernate.entity;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import java.util.Date;



public class BaseEntity {

    @Basic
    private Date createTime;
}
