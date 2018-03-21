package com.beads.model.dao;

import com.beads.model.config.BaseIntegrationTestConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexey.dranchuk on 02.10.14.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= BaseIntegrationTestConfiguration.class)
@Transactional
public class CommonDaoIT {
}
