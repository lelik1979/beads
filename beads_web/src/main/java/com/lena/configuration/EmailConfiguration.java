package com.lena.configuration;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 29.09.14.
 */
@Configuration
@PropertySource("classpath:/env/${env:dev}.properties")
public class EmailConfiguration {

    @Autowired
    private Environment env;

    public static final Logger LOG = LoggerFactory.getLogger(EmailConfiguration.class);

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public JavaMailSenderImpl emailSender() throws NamingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("smtp.host"));
        mailSender.setPort(env.getProperty("smtp.port", Integer.class));
        mailSender.setUsername(env.getProperty("smtp.user"));
        mailSender.setPassword(env.getProperty("smtp.password"));
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtps.auth", true);
        mailSender.setJavaMailProperties(props);
        return mailSender;

    }

    @Bean
    public VelocityEngine buildVelocityEngine() throws IOException {
        VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
        Properties prop = new Properties();
        prop.setProperty("resource.loader", "class");
        prop.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.setVelocityProperties(prop);
        return velocityEngine.createVelocityEngine();
    }
}
