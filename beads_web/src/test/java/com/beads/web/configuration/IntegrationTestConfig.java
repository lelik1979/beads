package com.beads.web.configuration;

import com.beads.db.config.FlywayConfiguration;
import com.beads.model.config.HibernateConfiguration;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db_test.properties")
@ComponentScan(basePackages = {"com.beads.web.dao", "com.beads.model.builder"})
@Import({FlywayConfiguration.class, HibernateConfiguration.class})
public class IntegrationTestConfig {

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
    prop.setProperty("url", environment.getProperty("url", "jdbc:mysql://localhost:3306/beads3_test"));
    prop.setProperty("username", environment.getProperty("username"));
    prop.setProperty("password", environment.getProperty("password"));
    prop.setProperty("defaultAutoCommit", "false");
    prop.setProperty("characterEncoding", "utf8");
    prop.setProperty("autoReconnect", "true");
    return prop;
  }
}
