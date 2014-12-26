package com.lena.vaadin.view;

import com.lena.vaadin.components.SearchModel;
import com.lena.vaadin.components.SearchPanel;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by alexey.dranchuk on 26/12/14.
 */

@Theme("reindeer")
public class ProductGroupWindow extends Panel implements View {

    public static final String VIEW_NAME = "productGroupView";

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupWindow.class);

    private VerticalLayout layout;

    public ProductGroupWindow() {
        super("Группы товаров");
        init();
    }

    private void init() {
        setSizeFull();
        initLayout();
        addComponents();
    }

    private void addComponents() {
        SearchPanel searchPanel = new SearchPanel(new SearchModel());
        layout.addComponent(searchPanel);
    }

    private void initLayout() {
        layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
