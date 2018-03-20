package com.beads.model.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * Created by alexey.dranchuk on 28.09.14.
 *
 */

@Configuration
@ComponentScan(basePackages = {"com.beads.model", "com.beads.db"})
@PropertySource("classpath:/env/${env:test}_db.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class HibernateConfigurationTest {

    @Autowired
    private Environment env;

    @Bean
    public DataSource beadDSTest() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("driver"));
        ds.setUsername(env.getProperty("username"));
        ds.setPassword(env.getProperty("password"));
        ds.setUrl(env.getProperty("url"));
        return ds;
    }

}
