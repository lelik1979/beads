package com.beads.web;

import com.beads.model.config.HibernateConfigurationTest;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"com.beads.web.dao", "com.beads.model.builder"})
@Transactional
public abstract class BaseIntegrationTest extends HibernateConfigurationTest {
}
