package com.lena.vaadin.view;

import com.lena.dao.ProductDao;
import com.lena.vaadin.components.BeadWindow;
import com.lena.vaadin.components.SearchModel;
import com.lena.vaadin.components.SearchPanel;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by alexey.dranchuk on 26/12/14.
 */
@Component
public class ProductGroupWindow extends BeadWindow {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupWindow.class);

    @Autowired
    private ProductDao productDao;

    private VerticalLayout layout;

    public ProductGroupWindow() {
        super("Группы продуктов");
        init();
    }

    private void init() {
        removePreviousWindow();
        setHeight(400, Unit.POINTS);
        setWidth(800, Unit.POINTS);

        initLayout();
        addComponents();

        center();
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

}
