package com.lena.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.Session;
import javax.naming.NamingException;

/**
 * Created by Administrator on 29.09.14.
 */
@Configuration
@PropertySources(value = {@PropertySource("classpath:/app.properties")})
public class EmailConfiguration {

    public static final Logger LOG = LoggerFactory.getLogger(EmailConfiguration.class);

    @Bean
    public JavaMailSenderImpl emailSender() throws NamingException {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setSession(getMailSession());
        return mailSenderImpl;
    }

    private Session getMailSession() throws  NamingException {
        JndiTemplate template = new JndiTemplate();
        return (Session) template.lookup("java:comp/env/mail/beadMail");
    }
}
