package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.components.search.SearchPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by alexey.dranchuk on 26/12/14.
 */

public class ProductGroupView extends Panel implements View {

    public static final String VIEW_NAME = "productGroupView";

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupView.class);

    private VerticalLayout layout;

    private ProductGroupViewModel productGroupWindowModel;

    private void init() {
        initLayout();
        addComponents();
        setSizeFull();
    }

    private void addComponents() {
        SearchPanel searchPanel = new SearchPanel(productGroupWindowModel.getSearchPanelModel());
        layout.addComponent(searchPanel);
        ProductGroupTreeTable table = new ProductGroupTreeTable(productGroupWindowModel.getProductGroupTableModel());
        layout.addComponent(table);
        addBottomPanel();
    }

    private void addBottomPanel() {
        ProductGroupBottomPanel bp = new ProductGroupBottomPanel(productGroupWindowModel.getBottomPanelModel());
        layout.addComponent(bp);
    }

    private void initLayout() {
        layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setCaption("Группы товаров");
        SpringContextHelper contextHelper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
        this.productGroupWindowModel = contextHelper.getBean(ProductGroupViewModel.class);
        init();
    }
}
