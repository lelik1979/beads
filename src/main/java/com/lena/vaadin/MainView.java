package com.lena.vaadin;

import com.lena.vaadin.components.BeadsMenu;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.VaadinView;
import javax.annotation.PostConstruct;

/**
 * Created by alexey.dranchuk on 23/12/14.
 */

@Component
@Scope("prototype")
@VaadinView(MainView.NAME)
public class MainView extends Panel implements View {

    public static final Logger LOG = LoggerFactory.getLogger(MainView.class);

    public static final String NAME = "";

    @PostConstruct
    public void init() {
        setSizeFull();

        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.addComponent(new BeadsMenu());

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        LOG.info("MainView.enter");
    }

}
