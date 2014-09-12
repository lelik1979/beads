package com.lena.configuration;

import com.lena.dao.RazdelDao;
import com.lena.service.RazdelService;
import com.lena.service.RazdelServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Administrator on 12.09.14.
 */
@Configuration
public class RazdelConfig {

    @Bean()
    public RazdelService razdelService(RazdelDao razdelDao) {
        RazdelServiceImpl service = new RazdelServiceImpl();
        service.setRazdelDao(razdelDao);
        return service;
    }

    @Bean
    public RazdelDao razdelDao() {
        RazdelDao razdelDao = new RazdelDao();
        return razdelDao;
    }
}
