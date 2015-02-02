package com.beads.email;

import com.beads.email.config.EmailConfiguration;
import com.beads.email.service.EmailJob;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext appCtx = SpringApplication.run(EmailConfiguration.class, args);
        EmailJob emailService = appCtx.getBean(EmailJob.class);
        emailService.processPendingOrders();
        SpringApplication.exit(appCtx);
    }


}
