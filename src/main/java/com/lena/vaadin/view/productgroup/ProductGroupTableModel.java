package com.lena.vaadin.view.productgroup;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.vaadin.data.util.BeanItemContainer;

import java.util.List;

/**
 * Created by alexey.dranchuk on 27/12/14.
 */
public class ProductGroupTableModel {

    private List<ProductGroup> productGroups;

    private BeanItemContainer<ProductGroup> container = new BeanItemContainer<ProductGroup>(ProductGroup.class);

    private Object[] visibleColumns = new Object[] {"id", "name", "parentName"};;

    private ProductGroupDao productGroupDao;

    public ProductGroupTableModel(ProductGroupDao productGroups) {
        this.productGroupDao = productGroups;
        populateContainer();
    }

    private void populateContainer() {
        productGroups = productGroupDao.findAllProductGroup();
        container.removeAllItems();
        for(ProductGroup pg : productGroups) {
            container.addBean(pg);
            container.addAll(pg.getChildGroups());
        }
    }

    public BeanItemContainer<ProductGroup> getContainer() {
        return container;
    }

    public Object[] getVisibleColumns() {
        return visibleColumns;
    }

    public void addItemFirst(ProductGroup pg) {
        container.addItemAt(0, pg);
    }

}
