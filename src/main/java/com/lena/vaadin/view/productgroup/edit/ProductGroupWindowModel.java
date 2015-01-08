package com.lena.vaadin.view.productgroup.edit;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.view.productgroup.ProductGroupTableModel;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductGroupWindowModel {

    private ProductGroup productGroup = new ProductGroup();
    private ProductGroupDao productGroupDao;
    private ProductGroupTableModel productGroupTreeTableModel;

    public ProductGroupWindowModel() {
    }

    public ProductGroupWindowModel(SpringContextHelper contextHelper) {
        productGroupDao = contextHelper.getProductGroupDao();
        productGroup = new ProductGroup();
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void saveProductGroup() {
        productGroupDao.saveProductGroup(productGroup);
        productGroupTreeTableModel.populateContainer();
    }

    public void setProductGroupTreeTableModel(ProductGroupTableModel productGroupTreeTableModel) {
        this.productGroupTreeTableModel = productGroupTreeTableModel;
    }
}
