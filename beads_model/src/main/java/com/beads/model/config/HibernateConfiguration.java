package com.beads.model.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * Created by alexey.dranchuk on 13.09.14.
 *
 */

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

    public static final String TRANSACTION_MANAGER_NAME = "hibernateTransactionManager";

    @Autowired
    private DataSource dataSource;


    @Bean
    public LocalSessionFactoryBean hibernateSessionFactory() throws Exception {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource);
        lsfb.setPackagesToScan("com.beads.model.domain");
        return lsfb;
    }

    @Bean(name=TRANSACTION_MANAGER_NAME)
    @Primary
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sf) throws Exception {
        return  new HibernateTransactionManager(sf);
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}
