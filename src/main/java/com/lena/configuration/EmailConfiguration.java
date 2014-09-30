package com.lena.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.Session;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Administrator on 29.09.14.
 */
@Configuration
@PropertySources(value = {@PropertySource("classpath:/app.properties")})
public class EmailConfiguration {

    @Autowired
    private Environment env;

    public static final Logger LOG = LoggerFactory.getLogger(EmailConfiguration.class);

    @Bean
    public JavaMailSenderImpl emailSender() throws NamingException {
//        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
//        mailSenderImpl.setSession(getMailSession());
//        return mailSenderImpl;
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

    private Session getMailSession() throws  NamingException {
        JndiTemplate template = new JndiTemplate();
        return (Session) template.lookup("java:comp/env/mail/beadMail");
    }
}
