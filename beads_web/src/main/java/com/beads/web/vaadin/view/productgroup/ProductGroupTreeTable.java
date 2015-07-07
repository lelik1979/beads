package com.beads.web.vaadin.view.productgroup;

import com.beads.model.domain.ProductGroup;
import com.vaadin.ui.TreeTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 26/12/14.
 *
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
        setColumnHeader(ProductGroup.ORDER_ID, "Порядок в списке");
        setColumnHeader(ProductGroup.PARENT_PRODUCT_NAME, "Родительская группа");
        setColumnHeader(ProductGroup.NAME, "Имя группы");
        setColumnHeader(ProductGroup.ID, "№");
    }

    private void addListeners() {
        LOG.trace("Added ItemClickListener {} to {}", model, this);
        addItemClickListener(model);
    }

}
