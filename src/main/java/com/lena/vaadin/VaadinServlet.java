package com.lena.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.DiscoveryNavigator;
import ru.xpoft.vaadin.SpringVaadinServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by adranchuk on 12/12/14.
 */

@WebServlet(name="vaadinServlet", value = {"/admin/*", "/VAADIN/*"},
        initParams = {
        @WebInitParam(name = "ui", value = "com.lena.vaadin.AdminUI"),
        @WebInitParam(name = "productionMode", value = "false") })
public class VaadinServlet extends com.vaadin.server.VaadinServlet {

}
