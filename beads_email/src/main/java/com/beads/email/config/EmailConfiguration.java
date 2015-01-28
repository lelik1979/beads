package com.beads.email.config;

import com.beads.email.service.OrderEmailProcessor;
import com.beads.email.service.OrderItemReader;
import com.beads.model.domain.Order;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

@ComponentScan(basePackages = {"com.beads.model", "com.beads.email"})
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class EmailConfiguration {

    @Autowired
    private OrderItemReader orderItemReader;

    @Autowired
    private OrderEmailProcessor orderEmailProcessor;

    @Bean
    public ItemReader<Order> reader() {
        return orderItemReader;
    }

    @Bean
    public ItemProcessor<Order, Order> processor() {
        return orderEmailProcessor;
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("sendOrderEmails")
                .incrementer(new RunIdIncrementer())
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("sendEmail")
                .<Order, Order> chunk(10)
                .reader(orderItemReader)
                .processor(orderEmailProcessor)
//                .writer(writer)
                .build();
    }
}
