package com.lena.vaadin.view.productgroup.edit;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
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

    public ProductGroupWindowModel(ProductGroupDao productGroupDao) {
        this.productGroupDao = productGroupDao;
        productGroup = new ProductGroup();
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public void saveProductGroup() {
        productGroupDao.saveOrUpdate(productGroup);
        productGroupTreeTableModel.populateContainer();
    }

    public void setProductGroupTreeTableModel(ProductGroupTableModel productGroupTreeTableModel) {
        this.productGroupTreeTableModel = productGroupTreeTableModel;
    }
}
