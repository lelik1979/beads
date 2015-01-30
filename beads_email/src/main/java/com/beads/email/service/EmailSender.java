package com.beads.email.service;

import com.beads.model.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by alexey.dranchuk on 29/1/15.
 *
 */

@Service
public class EmailSender {

    public static final Logger LOG = LoggerFactory.getLogger(EmailSender.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${smtp.user}")
    private String fromUser;

    @Value("${manager.email}")
    private String managerEmail;

    @Autowired
    private EmailGenerator emailGenerator;

    public boolean sendEmail(Order order) {
        try {
            prepareAndSendMailToManager(order);
            return true;
        } catch (MessagingException ex) {
            LOG.warn("There was a problem during sending email", ex);
            return false;
        }
    }

    private void prepareAndSendMailToManager(Order order) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "utf-8");
        message.setFrom(fromUser);
        message.setTo(managerEmail);
        message.setSubject("Новый заказ");
        message.setText(emailGenerator.getEmailBody(order), true);
        mailSender.send(mimeMessage);
        LOG.info("Email has been to {} for order.id={}", order.getEmail(), order.getId());
    }
}
