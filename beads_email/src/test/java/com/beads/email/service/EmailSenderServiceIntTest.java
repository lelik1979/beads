package com.beads.email.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.beads.email.util.Batch;
import com.beads.model.domain.Order;
import java.util.Arrays;
import org.junit.Test;
import org.mockito.Mockito;

public class EmailSenderServiceIntTest {

    private EmailSender emailSenderMock = mock(EmailSender.class);
    private EmailSenderService emailSenderService = mock(EmailSenderService.class);

    @Test
    public void testSendEmail() throws Exception {
        when(emailSenderMock.sendEmail(any(Order.class))).thenReturn(true);

        Batch testBatch = new Batch(Arrays.asList(1));
        emailSenderService.sendEmail(testBatch);

        Mockito.verify(emailSenderService, Mockito.times(1)).sendEmail(testBatch);
    }
}