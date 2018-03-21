package com.beads.model.config;

import static com.beads.db.config.FlywayConfiguration.FLYWAY_BEAN;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

    @DependsOn(FLYWAY_BEAN)
    @Bean
    public LocalSessionFactoryBean hibernateSessionFactory() {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource);
        lsfb.setPackagesToScan("com.beads.model.domain");
        return lsfb;
    }

    @Bean(name=TRANSACTION_MANAGER_NAME)
    @Primary
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sf) {
        return  new HibernateTransactionManager(sf);
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}
