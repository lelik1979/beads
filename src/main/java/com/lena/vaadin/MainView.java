package com.lena.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

    public static final String NAME = "";

    @Autowired
    private transient ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        Button button = new Button("change");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                System.out.println("clicked");
            }
        });
        layout.addComponent(button);
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
    }

}
