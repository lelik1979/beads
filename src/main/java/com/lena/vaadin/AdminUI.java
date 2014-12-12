package com.lena.vaadin;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by adranchuk on 12/12/14.
 */

public class AdminUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();
        setContent(new Button("sdsd"));
    }
}
