package com.lena.service.job;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;

import java.util.Properties;

/**
 * Created by Administrator on 30.09.14.
 */

@Configuration
@ComponentScan(basePackages = {"com.lena.service"})
//@ContextConfiguration(classes = com.beads.email.config.EmailConfiguration.class)
public class EmailServiceConfigurationTest {

    @Bean
    public JavaMailSenderImpl emailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("bbead72@gmail.com");
        mailSender.setPassword("KtyfKtyf");
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtps.auth", true);
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }

}
