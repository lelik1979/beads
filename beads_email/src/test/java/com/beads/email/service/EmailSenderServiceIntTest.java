package com.beads.email.service;

import com.beads.email.config.EmailConfiguration;
import com.beads.email.util.Batch;
import com.beads.model.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmailConfiguration.class)
@Transactional
public class EmailSenderServiceIntTest {

    @Autowired
    @InjectMocks
    private EmailSenderService emailSenderService;

    private EmailSender emailSenderMock = mock(EmailSender.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendEmail() throws Exception {
        when(emailSenderMock.sendEmail(any(Order.class))).thenReturn(true);

        Batch testBatch = new Batch(Arrays.asList(38));
        emailSenderService.sendEmail(testBatch);
    }
}