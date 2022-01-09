package com.zj.springboothibernate.entity;


import lombok.Data;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;


@Data

@Entity
@DiscriminatorOptions(force=true)
@Inheritance
//@DiscriminatorValue("huwu")
//@DiscriminatorColumn(name="discriminator",discriminatorType= DiscriminatorType.STRING)
public class PcUser extends User{

    @Basic
    private String text;
}
