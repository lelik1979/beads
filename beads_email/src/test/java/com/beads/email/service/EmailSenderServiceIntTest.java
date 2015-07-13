package com.beads.email.service;

import com.beads.email.util.Batch;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import java.util.Arrays;

public class EmailSenderServiceIntTest extends BaseIT{

    @Autowired
    @InjectMocks
    private EmailSenderService emailSenderService;

//    private EmailSender emailSenderMock = mock(EmailSender.class);

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Rollback(true)
    public void testSendEmail() throws Exception {
//        when(emailSenderMock.sendEmail(any(Order.class))).thenReturn(true);

        Batch testBatch = new Batch(Arrays.asList(1));
        emailSenderService.sendEmail(testBatch);
    }
}