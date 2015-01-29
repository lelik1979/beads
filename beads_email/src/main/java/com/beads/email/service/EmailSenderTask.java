package com.beads.email.service;

import com.beads.email.util.Batch;

/**
 * Created by alexey.dranchuk on 26/1/15.
 *
 */

public class EmailSenderTask implements Runnable {

    private EmailSenderService emailSender;

    private Batch batch;

    public EmailSenderTask(Batch batch, EmailSenderService emailSender) {
        this.batch = batch;
        this.emailSender = emailSender;
    }

    @Override
    public void run() {
        emailSender.sendEmail(batch);
    }

}
