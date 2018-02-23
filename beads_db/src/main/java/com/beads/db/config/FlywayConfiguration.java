package com.beads.db.config;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfiguration {

  @Autowired
  private DataSource dataSource;

  public static final String FLYWAY_BEAN = "flywayBean";

  /**
   * Configure and return a Flyway to create database schema.
   *
   * @return Flyway configured from injected properties
   */
  @Bean(name = FLYWAY_BEAN, initMethod = "migrate")
  public Flyway initFlyway() {
    Flyway flyway = new Flyway();
    flyway.setDataSource(dataSource);
    flyway.setLocations("db_scripts");
    return flyway;
  }
}
