package com.beads.email.service;

import com.beads.email.dao.OrderDao;
import com.beads.email.util.Batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by alexey.dranchuk on 17/1/15.
 *
 */

@Service
public class EmailJobService {

    public static final Logger LOG = LoggerFactory.getLogger(EmailJobService.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private BatchSpliter batchSpliter;

    @Autowired
    private EmailSenderService emailSenderService;

    public void processPendingOrders() throws InterruptedException {
        LOG.debug("email job");
        List<Integer> orders;
        do {
            orders = orderDao.loadPendingOrderIds();
            processRows(orders);
        } while (orders.size() == batchSpliter.getMaxQuerySize());
        executor.shutdown();
    }

    private void processRows(List<Integer> orders) throws InterruptedException {
        for(Batch batch : batchSpliter.splitByBatches(orders)) {
            executor.execute(new EmailSenderTask(batch, emailSenderService));
        }
        while (executor.getActiveCount() != 0) {
            Thread.sleep(3000);
        }
    }
}
