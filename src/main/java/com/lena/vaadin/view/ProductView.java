package com.lena.vaadin.view;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
@Theme("reindeer")
public class ProductView extends Panel implements View {

    public ProductView() {
        setSizeFull();
        setImmediate(true);
        setContent(new Label("ProductView"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
