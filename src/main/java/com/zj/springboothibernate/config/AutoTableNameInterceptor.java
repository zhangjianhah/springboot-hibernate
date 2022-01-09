package com.zj.springboothibernate.config;

import org.hibernate.EmptyInterceptor;

import java.io.Serializable;

public class AutoTableNameInterceptor extends EmptyInterceptor {




    @Override
    public String onPrepareStatement(String sql) {
//        System.out.println(sql);

        sql = sql.replaceAll("DTYPE='PcUser'","DTYPE is not null");
        return sql;
    }
}
