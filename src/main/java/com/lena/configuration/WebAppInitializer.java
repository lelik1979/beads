package com.lena.configuration;

import com.github.dandelion.core.DandelionMode;
import com.github.dandelion.core.config.DandelionConfig;
import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.xpoft.vaadin.SpringApplicationContext;
import ru.xpoft.vaadin.SpringVaadinServlet;

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
        dandelionFilter.setInitParameter(DandelionConfig.DANDELION_MODE.getName(), DandelionMode.PRODUCTION.name());

        DandelionServlet dispatcherServlet = new DandelionServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("dandelionServlet", dispatcherServlet);
        registration.setLoadOnStartup(2);
        registration.addMapping("/dandelion-assets/*");

        SpringVaadinServlet vaadinServlet = new SpringVaadinServlet();
        servletContext.setInitParameter("beanName", "MainUI");

        ServletRegistration.Dynamic vaadinRegistration = servletContext.addServlet("vaadinServlet", vaadinServlet);
        vaadinRegistration.setLoadOnStartup(100);
        vaadinRegistration.addMapping("/admin/*", "/VAADIN/*");

        servletContext.setInitParameter("productionMode", "false");

    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext webAppContext = super.createRootApplicationContext();
        if (webAppContext != null && SpringApplicationContext.getApplicationContext() == null)
            SpringApplicationContext.setApplicationContext(webAppContext);
        return webAppContext;
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
