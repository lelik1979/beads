package com.lena.configuration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * Created by Administrator on 12.09.14.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        FilterRegistration.Dynamic dandelionFilter = servletContext.addFilter("dandelionFilter", new DandelionFilter());
        dandelionFilter.addMappingForUrlPatterns(null, false, "/*");

        DandelionServlet dispatcherServlet = new DandelionServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("dandelionServlet", dispatcherServlet);
        registration.setLoadOnStartup(2);
        registration.addMapping("/dandelion-assets/*");

    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class, AppContext.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");

        return new Filter[]{characterEncodingFilter};
    }
}
