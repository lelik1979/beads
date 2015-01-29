package com.beads.email.service;

import com.beads.email.config.Constant;
import com.beads.email.util.Batch;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by alexey.dranchuk on 26/1/15.
 *
 */

@Component
public class BatchSpliter {

    @Autowired
    private Environment env;


    public Integer getThreadCount() {
        return env.getProperty(Constant.THREAD_COUNT, Integer.class, 10);
    }

    public Integer getMaxQuerySize() {
        return env.getProperty(Constant.MAX_QUERY_SIZE, Integer.class, 10000);
    }

    public Integer getBatchSize() {
        return env.getProperty(Constant.BATCH_SIZE, Integer.class, 1000);
    }

    public List<Batch> splitByBatches(List<Integer> orders) {
        List<List<Integer>> batches = Lists.partition(orders, getBatchSize());
        return Lists.transform(batches, new Function<List<Integer>, Batch>() {
            @Override
            public Batch apply(List<Integer> input) {
                return new Batch(input);
            }
        });
    }
}
