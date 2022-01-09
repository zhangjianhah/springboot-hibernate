package com.zj.springboothibernate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix = "zj.hibernate")
@Data
//@Component
public class HibernateProperties {

    private String ddlAuto;
    private String dialect;
    private boolean showSql;
    private String packagesToScan;
    private String currentSessionContextClass;



}
