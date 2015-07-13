package com.beads.email.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author alexey.dranchuk
 */
public class EmailJobIT  extends BaseIT{

    @Autowired
    private EmailJob emailJob;

    @Test
    public void runJob() throws InterruptedException {
        emailJob.processPendingOrders();
    }
}
