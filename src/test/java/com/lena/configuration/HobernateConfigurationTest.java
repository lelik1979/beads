package com.lena.configuration;

import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Administrator on 28.09.14.
 */
@Configuration
@ComponentScan(basePackages = {"com.lena.dao"})
@EnableTransactionManagement(proxyTargetClass = true)
public class HobernateConfigurationTest {

    @Bean
    public DataSource beadDSTest() {
        DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("bead");
        ds.setPassword("bead");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/bead");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean getHibernateSessionFactory() throws Exception {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(beadDSTest());
        lsfb.setPackagesToScan("com.lena.domain");
        return lsfb;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sf) throws Exception {
        return  new HibernateTransactionManager(sf);
    }


}
