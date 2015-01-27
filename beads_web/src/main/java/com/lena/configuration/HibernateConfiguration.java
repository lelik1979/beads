package com.lena.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Administrator on 13.09.14.
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

    @Resource(mappedName = "jdbc/MySQLDS")
    private DataSource dataSource;

    @Bean
    public DataSource dataSource() throws Exception {
        return  dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getHibernateSessionFactory() throws Exception {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource());
        lsfb.setPackagesToScan("com.lena.domain");
        return lsfb;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sf) throws Exception {
        return  new HibernateTransactionManager(sf);
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}
