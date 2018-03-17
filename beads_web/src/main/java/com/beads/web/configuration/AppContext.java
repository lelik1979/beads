package com.beads.web.configuration;

import java.util.Locale;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Created by alexey.dranchuk on 15.11.14.
 *
 */

@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "com.beads.web", "com.beads.model", "com.beads.db"})
public class AppContext {

    @Resource(mappedName = "jdbc/MySQLDS")
    private DataSource dataSource;

    @Bean
    public DataSource dataSource() {
        return  dataSource;
    }


    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setDefaultEncoding("UTF8");
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("ru"));
        return localeResolver;
    }

}
