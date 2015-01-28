package com.lena.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import java.util.List;

/**
 * Created by alexey.dranchuk on 12.09.14.
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.lena.webcontroller"})
@Import({ThymeleafConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final boolean jackson2Present =
    ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", WebConfig.class.getClassLoader()) &&
            ClassUtils.isPresent("com.fasterxml.jackson.core.JsonGenerator", WebConfig.class.getClassLoader());

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (jackson2Present)
            converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

}
