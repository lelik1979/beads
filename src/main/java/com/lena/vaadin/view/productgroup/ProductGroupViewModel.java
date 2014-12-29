package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.SpringContextHelper;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductGroupViewModel {

    private SearchModel searchPanelModel;

    private ProductGroupTableModel productGroupTableModel;

    private WebApplicationContext appContext;
    private BottomPanelModel bottomPanelModel;

    public ProductGroupViewModel(SpringContextHelper contextHelper) {
        this.appContext = contextHelper.getWebAppContext();
        this.productGroupTableModel = new ProductGroupTableModel(contextHelper.getProductGroupDao());
        this.searchPanelModel = new SearchModel();
        this.bottomPanelModel = new BottomPanelModel(contextHelper);
        bottomPanelModel.setProductGroupViewModel(this);
    }

    public SearchModel getSearchPanelModel() {
        return searchPanelModel;
    }

    public ProductGroupTableModel getProductGroupTableModel() {
        return productGroupTableModel;
    }

    public WebApplicationContext getAppContext() {
        return appContext;
    }

    public BottomPanelModel getBottomPanelModel() {
        return bottomPanelModel;
    }
}
