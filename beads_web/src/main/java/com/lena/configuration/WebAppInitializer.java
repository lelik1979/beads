package com.lena.configuration;

import com.github.dandelion.core.DandelionMode;
import com.github.dandelion.core.config.DandelionConfig;
import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.*;

/**
 * Created by alexey.dranchuk on 12.09.14.
 *
 */

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        FilterRegistration.Dynamic dandelionFilter = servletContext.addFilter("dandelionFilter", new DandelionFilter());
        dandelionFilter.addMappingForUrlPatterns(null, false, "/*");
        dandelionFilter.setInitParameter(DandelionConfig.DANDELION_MODE.getName(), DandelionMode.PRODUCTION.name());

        DandelionServlet dispatcherServlet = new DandelionServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("dandelionServlet", dispatcherServlet);
        registration.setLoadOnStartup(2);
        registration.addMapping("/dandelion-assets/*");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
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
