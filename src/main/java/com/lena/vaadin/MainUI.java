package com.lena.vaadin;

import com.lena.vaadin.components.ContextPanel;
import com.lena.vaadin.components.MenuPanel;
import com.lena.vaadin.view.ProductGroupWindow;
import com.lena.vaadin.view.ProductView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import javax.servlet.annotation.WebServlet;

/**
 * Created by alexey.dranchuk on 23/12/14.
 */

@Title("Админстрирование Beads")
@Theme("reindeer")
public class MainUI extends UI {

    @WebServlet(urlPatterns = {"/admin/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();
        HorizontalSplitPanel layout = new HorizontalSplitPanel();
        layout.setFirstComponent(new MenuPanel());
        layout.setSplitPosition(15, Unit.PERCENTAGE);
        ContextPanel cp = new ContextPanel();
        layout.setSecondComponent(cp);
        layout.setSizeFull();
        Navigator navigator = new Navigator(this, cp);
        navigator.addView(ProductGroupWindow.VIEW_NAME, ProductGroupWindow.class);
        navigator.addView("product", ProductView.class);
        navigator.addView("", ContextPanel.class);
        setContent(layout);
    }


}
