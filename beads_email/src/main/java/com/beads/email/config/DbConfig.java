package com.beads.email.config;

import com.beads.db.config.FlywayConfiguration;
import com.beads.model.config.HibernateConfiguration;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

@Configuration
@PropertySource("classpath:/env/${env:dev}_db.properties")
@Import({FlywayConfiguration.class, HibernateConfiguration.class})
public class DbConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource() throws Exception {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        return  dataSourceFactory.createDataSource(getProperties());
    }

    private Properties getProperties() {
        Properties prop = new Properties();
        prop.setProperty("driverClassName", environment.getProperty("driver", "com.mysql.jdbc.Driver"));
        prop.setProperty("url", environment.getProperty("url", "jdbc:mysql://localhost:3306/beads3"));
        prop.setProperty("username", environment.getProperty("username"));
        prop.setProperty("password", environment.getProperty("password"));
        prop.setProperty("defaultAutoCommit", "false");
        prop.setProperty("characterEncoding", "utf8");
        prop.setProperty("autoReconnect", "true");
        return prop;
    }
}
