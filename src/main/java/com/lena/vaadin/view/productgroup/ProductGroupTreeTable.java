package com.lena.vaadin.view.productgroup;

import com.lena.domain.ProductGroup;
import com.vaadin.data.Item;
import com.vaadin.ui.Tree;
import com.vaadin.ui.TreeTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class ProductGroupTreeTable extends TreeTable {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupTreeTable.class);

    private ProductGroupTableModel model;

    public ProductGroupTreeTable(ProductGroupTableModel model) {
        this.model = model;
        setContainerDataSource(model.getContainer());
        setVisibleColumns(model.getVisibleColumns());
        setColumnNames();
        setCaption("Группы товаров");
        setSizeFull();
        setSelectable(true);
        setImmediate(true);
        addListeners();
    }

    private void setColumnNames() {
        setColumnHeader(ProductGroup.PARENT_PRODUCT_NAME, "Родительская группа");
        setColumnHeader(ProductGroup.NAME, "Имя группы");
        setColumnHeader(ProductGroup.ID, "№");
    }

    private void addListeners() {
        LOG.trace("Added ItemClickListener {} to {}", model, this);
        addItemClickListener(model);
    }

}
