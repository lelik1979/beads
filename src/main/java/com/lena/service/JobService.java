package com.lena.service;

import com.lena.service.job.EmailJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 29.09.14.
 */
@Service
public class JobService {

    @Autowired
    private EmailJobService emailJobService;

    private static final Logger LOG  = LoggerFactory.getLogger(JobService.class);

    @Scheduled(cron="${email.job.schedule}")
    public void processOrders() {
        emailJobService.processPendingOrders();
    }
}
