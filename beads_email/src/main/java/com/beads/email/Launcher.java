package com.beads.email;

import com.beads.email.config.EmailConfiguration;
import com.beads.email.service.EmailJobService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext appCtx = SpringApplication.run(EmailConfiguration.class, args);
        EmailJobService emailService = appCtx.getBean(EmailJobService.class);
        emailService.processPendingOrders();
        SpringApplication.exit(appCtx);
    }


}
