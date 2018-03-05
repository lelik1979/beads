package com.beads.web.vaadin;

import com.beads.web.vaadin.components.ContextPanel;
import com.beads.web.vaadin.components.MenuPanel;
import com.beads.web.vaadin.view.order.OrderView;
import com.beads.web.vaadin.view.product.ProductView;
import com.beads.web.vaadin.view.productgroup.ProductGroupView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;

/**
 * Created by alexey.dranchuk on 23/12/14.
 *
 */
@Title("Админстрирование Beads")
@Theme("reindeer")
public class MainUI extends UI {

    @WebServlet(urlPatterns = {"/admin/*", "/VAADIN/*"}, asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    @ServletSecurity(value = @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL))
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
        initNavigator(cp);
        setContent(layout);
    }

    private void initNavigator(ContextPanel cp) {
        Navigator navigator = new Navigator(this, cp);
        navigator.addView(ProductGroupView.VIEW_NAME, ProductGroupView.class);
        navigator.addView(ProductView.VIEW_NAME, ProductView.class);
        navigator.addView(OrderView.VIEW_NAME, OrderView.class);
        navigator.addView("", ContextPanel.class);
    }
}
