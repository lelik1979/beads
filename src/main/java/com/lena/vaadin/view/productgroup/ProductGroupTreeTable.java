package com.lena.vaadin.view.productgroup;

import com.lena.domain.ProductGroup;
import com.vaadin.ui.TreeTable;

import java.util.List;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class ProductGroupTreeTable extends TreeTable {


    private ProductGroupTableModel model;

    public ProductGroupTreeTable(ProductGroupTableModel model) {
        this.model = model;
        setContainerDataSource(model.getContainer());
        setParent(model);
        setVisibleColumns(model.getVisibleColumns());
        setCaption("Группы товаров");
        setSizeFull();
        setSelectable(true);
        setImmediate(true);
    }

    private void setParent(ProductGroupTableModel model) {
        for (ProductGroup pg : model.getContainer().getItemIds()) {
            addChilds(pg.getChildGroups(), pg);
        }
    }

    private void addChilds(List<ProductGroup> childGroups, ProductGroup parent) {
        for (ProductGroup pg : childGroups) {
            setParent(pg, parent);
        }

    }
}
