package com.lena.service.email;

import com.lena.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;

/**
 * Created by Administrator on 29.09.14.
 */
@Service
@PropertySource("classpath:/app.properties")
public class EmailService {

    public static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    Environment env;

    public boolean sendEmail(Order order) {
        try {
            prepareAndSendMail(order);
            return true;
        } catch (MessagingException ex) {
            LOG.warn("There was a problem during sending email", ex);
            return false;
        }
    }

    private void prepareAndSendMail(Order order) throws MessagingException {

        final MimeMessage mimeMessage = mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setFrom(env.getProperty("smtp.user"));
        message.setTo(order.getEmail());
        message.setSubject("new order");
        message.setText("new order with id=" + order.getId());
        mailSender.send(mimeMessage);
    }
}
