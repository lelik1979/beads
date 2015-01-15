package com.lena.vaadin.view.productgroup;

import com.lena.domain.ProductGroup;
import com.lena.vaadin.components.common.ButtonPanelModel;
import com.lena.vaadin.view.productgroup.edit.ProductGroupWindow;
import com.lena.vaadin.view.productgroup.edit.ProductGroupWindowModel;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
@Component
public class BottomPanelModel implements ButtonPanelModel {

    @Autowired
    private ProductGroupWindowModel productGroupWindowModel;

    @Autowired
    private ProductGroupViewModel productGroupViewModel;

    public static final Logger LOG = LoggerFactory.getLogger(BottomPanelModel.class);

    @Override
    public void newButtonClick() {
        LOG.debug("Clicked on New ProductGroup");
        productGroupWindowModel.setProductGroup(new ProductGroup());
        ProductGroupWindow productGroupWindow = new ProductGroupWindow(productGroupWindowModel);
        UI.getCurrent().addWindow(productGroupWindow);
    }

    @Override
    public void deleteButtonClick() {
        productGroupViewModel.getProductGroupTableModel().deleteButtonClick();
    }
}
