package com.beads.email.config;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

@ComponentScan(basePackages = {"com.beads.model", "com.beads.email"})
@Configuration
public class EmailConfiguration {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(10);
        poolTaskExecutor.setMaxPoolSize(10);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        poolTaskExecutor.setThreadNamePrefix("emailSenderThreadPoolTaskExecutor-");
        return poolTaskExecutor;
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setThreadNamePrefix("emailSenderThreadPoolTaskScheduler-");
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        return new ThreadPoolTaskScheduler();
    }

}
