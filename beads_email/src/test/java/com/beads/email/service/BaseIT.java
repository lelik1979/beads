package com.beads.email.service;

import com.beads.email.config.EmailConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alexey.dranchuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmailConfiguration.class)
@TestPropertySource(properties = {"env=test"})
@Transactional
public class BaseIT {
}
