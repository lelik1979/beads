package com.lena.vaadin.view.product;

import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.view.product.component.ProductTable;
import com.lena.vaadin.view.productgroup.SearchPanel;
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

    public ProductView() {
        super("Работа с товаром");
        SpringContextHelper contextHelper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
        initModels(contextHelper);
        initLayout();
        addComponents();
        setSizeFull();
    }

    private void initModels(SpringContextHelper contextHelper) {
        this.productViewModel = contextHelper.getWebAppContext().getBean(ProductViewModel.class);
    }

    private void addComponents() {
        SearchPanel searchPanel = new SearchPanel(productViewModel.getSearchPanelModel());
        layout.addComponent(searchPanel);
        ProductTable table = new ProductTable(productViewModel.getProductTableModel());
        layout.addComponent(table);
//        addBottomPanel();
    }

    private void initLayout() {
        layout = new VerticalLayout();
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
