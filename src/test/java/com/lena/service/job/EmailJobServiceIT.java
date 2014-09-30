package com.lena.service.job;

import com.lena.configuration.HobernateConfigurationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={HobernateConfigurationTest.class, EmailServiceConfigurationTest.class})
public class EmailJobServiceIT {

    @Autowired
    private EmailJobService sut;

    @Test
    public void processOrder() {
        sut.processPendingOrders();
    }

}