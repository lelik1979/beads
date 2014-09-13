package com.lena;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 09.09.14.
 */
public class ConfigTest {

    Config config;

    @Before
    public void init() {
        config = ConfigFactory.load();
    }

    @Test
    public void test1() {
        System.out.println("test run");
        String dbName = config.getString("DB_NAME");
    }
}
