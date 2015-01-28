package com.beads.email;

import com.beads.email.config.EmailConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

public class Launcher {

    public static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
        LOG.warn("started");
        disableBatchSqls();
        ConfigurableApplicationContext appContext = SpringApplication.run(EmailConfiguration.class, args);
    }

    private static void disableBatchSqls() {
        System.setProperty("spring.batch.initializer.enabled", "false");
    }
}
