package com.lena.vaadin.components;

import com.lena.vaadin.components.common.MenuItemClickListener;
import com.lena.vaadin.view.ProductGroupWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class MenuPanel extends VerticalLayout {

    public static final Logger LOG = LoggerFactory.getLogger(MenuPanel.class);


    public MenuPanel() {
        setHeight(100, Unit.POINTS);
        setMargin(true);
        setImmediate(true);
        initComponents();
    }

    private void initComponents() {
        addComponent(new Button("Группы продуктов", new MenuItemClickListener(ProductGroupWindow.VIEW_NAME)));
        addComponent(new Button("Товар", new MenuItemClickListener("product")));
        addComponent(new Button("Заказы"));
    }
}
