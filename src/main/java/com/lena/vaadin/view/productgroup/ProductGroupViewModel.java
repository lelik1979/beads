package com.lena.vaadin.view.productgroup;

import com.github.wolfie.blackboard.Blackboard;
import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.components.search.SearchModel;
import com.lena.vaadin.view.productgroup.listener.ProductGroupSearchEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductGroupViewModel {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupViewModel.class);

    private SearchModel searchPanelModel;

    private ProductGroupTableModel productGroupTableModel;

    private WebApplicationContext appContext;
    private BottomPanelModel bottomPanelModel;

    private final Blackboard blackboard = new Blackboard();

    public ProductGroupViewModel(SpringContextHelper contextHelper) {
        this.appContext = contextHelper.getWebAppContext();
        this.productGroupTableModel = new ProductGroupTableModel(contextHelper.getProductGroupDao());
        this.searchPanelModel = new SearchModel(blackboard);
        this.bottomPanelModel = new BottomPanelModel(contextHelper);
        bottomPanelModel.setProductGroupViewModel(this);
        initListeners();
    }

    private void initListeners() {
        if (LOG.isDebugEnabled())
            blackboard.enableLogging();
        blackboard.register(ProductGroupSearchEvent.ProductGroupSearchListener.class, ProductGroupSearchEvent.class);
        blackboard.addListener(productGroupTableModel);
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
