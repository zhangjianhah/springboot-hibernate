package com.zj.springboothibernate.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;




import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
//@EnableConfigurationProperties({HibernateProperties.class})
@EnableTransactionManagement
//@EnableJpaRepositories
public class SessionFactoryConfiguration {






    @Bean
    @ConfigurationProperties(prefix = "zj.hibernate")
    public HibernateProperties hibernateProperties(){
        return new HibernateProperties();
    }






    @Autowired
    private SessionFactory sessionFactory;


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }



    @Bean
    public AutoTableNameInterceptor autoTableNameInterceptor(){
        return new AutoTableNameInterceptor();
    }



    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(){
        Properties properties=new Properties();
        HibernateProperties hibernateProperties = hibernateProperties();
        properties.setProperty("hibernate.show_sql", String.valueOf( hibernateProperties.isShowSql()));
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateProperties.getDdlAuto());
        properties.setProperty("hibernate.dialect", hibernateProperties.getDialect());
        //事务
        properties.setProperty("hibernate.current_session_context_class", hibernateProperties.getCurrentSessionContextClass());


        LocalSessionFactoryBean lsb=new LocalSessionFactoryBean();
        lsb.setDataSource(druidDataSource());
        lsb.setPackagesToScan(hibernateProperties.getPackagesToScan());
        lsb.setHibernateProperties(properties);

        lsb.setEntityInterceptor(autoTableNameInterceptor());


//        lsb.setHibernateProperties();

        return lsb;

    }



    @Bean
    public HibernateTemplate hibernateTemplate(){
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory);
        return hibernateTemplate;
    }

    /*@Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager ts = new HibernateTransactionManager();
        ts.setSessionFactory(sessionFactory);
        return ts;
    }*/
}
