package com.lena.vaadin.components;

import com.lena.vaadin.view.ProductGroupWindow;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class BeadsMenu extends MenuBar {

    public static final Logger LOG = LoggerFactory.getLogger(BeadsMenu.class);

    public BeadsMenu() {
        addMenuItems();
    }

    private void addMenuItems() {
        addProductGroupMenuItem();
    }

    private void addProductGroupMenuItem() {
        MenuBar.Command productGroupMenuCommand = new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                LOG.debug("selected menu item : {}", selectedItem.getText());
                ProductGroupWindow sub = new ProductGroupWindow();
                UI.getCurrent().addWindow(sub);
            }
        };
        addItem("Группы товаров", null, productGroupMenuCommand);
    }
}
