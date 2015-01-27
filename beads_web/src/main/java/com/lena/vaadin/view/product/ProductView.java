package com.lena.vaadin.view.product;

import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.view.product.component.ProductTable;
import com.lena.vaadin.components.search.SearchPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class ProductView extends Panel implements View {

    public static final String VIEW_NAME = "productView";

    private ProductViewModel productViewModel;

    private Layout layout;

    private void addComponents() {
        SearchPanel searchPanel = new SearchPanel(productViewModel.getSearchPanelModel());
        layout.addComponent(searchPanel);
        ProductTable table = new ProductTable(productViewModel.getProductTableModel());
        layout.addComponent(table);
        addBottomPanel();
    }

    private void addBottomPanel() {
        ProductBottomPanel bp = new ProductBottomPanel(productViewModel.getButtonPanelModel());
        layout.addComponent(bp);
    }

    private void initLayout() {
        layout = new VerticalLayout();
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        setCaption("Работа с товаром");
        SpringContextHelper contextHelper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
        this.productViewModel = contextHelper.getBean(ProductViewModel.class);
        initLayout();
        addComponents();
        setSizeFull();

    }
}
