package com.lena.dao;

import com.lena.domain.Razdel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Administrator on 25.08.14.
 */
public class RazdelDao {

    public static final Logger LOG = LoggerFactory.getLogger(RazdelDao.class);

    public void init() {
        LOG.debug("started");
    }
}
