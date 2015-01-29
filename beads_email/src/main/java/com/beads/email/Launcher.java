package com.beads.email;

import com.beads.email.config.EmailConfiguration;
import org.springframework.boot.SpringApplication;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(EmailConfiguration.class, args);
    }


}
