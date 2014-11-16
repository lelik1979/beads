package com.lena.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 15.11.14.
 */
@Configuration
@ComponentScan(basePackages = { "com.lena.*"})
public class RootConfig {
}
