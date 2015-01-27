package com.lena.vaadin;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContext;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class SpringContextHelper {

    private WebApplicationContext context;

    public SpringContextHelper(ServletContext servletContext) {
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    public Object getBean(final String beanRef) {
        return context.getBean(beanRef);
    }

    public <T> T getBean(final Class<T> clazz) {
        return context.getBean(clazz);
    }

}
