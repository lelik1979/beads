package com.beads.web.configuration;

import com.beads.model.config.BaseIntegrationTestConfiguration;
import com.beads.model.config.HibernateConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.beads.web.dao", "com.beads.model.builder"})
@Import({BaseIntegrationTestConfiguration.class, HibernateConfiguration.class})
public class IntegrationTestConfig {
}
