package com.lena.configuration;

import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:/env/${env:dev}.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class HibernateConfigurationTest {

    @Autowired
    private Environment env;

    @Bean
    public DataSource beadDSTest() {
        DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("driver", "com.mysql.jdbc.Driver"));
        ds.setUsername(env.getProperty("username", "beads3"));
        ds.setPassword(env.getProperty("password", "beads3"));
        ds.setUrl(env.getProperty("url", "jdbc:log4jdbc:mysql://localhost:3306/beads3"));
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
