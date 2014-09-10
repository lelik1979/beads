package com.lena.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 10.09.14.
 */
@ContextConfiguration(locations = {
        "classpath:spring/out-container.xml",
        "classpath:spring/dao.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Override
    @Autowired
    @Qualifier("beadDS")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
