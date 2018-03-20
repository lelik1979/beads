package com.beads.web.vaadin.view.product.component;

import com.beads.model.domain.Product;
import com.vaadin.ui.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 8/1/15.
 *
 */
public class ProductTable extends Table {

    public static final Logger LOG = LoggerFactory.getLogger(ProductTable.class);

    private ProductTableModel model;

    public ProductTable(ProductTableModel model) {
        this.model = model;
        setContainerDataSource(model);
        setVisibleColumns(model.getVisibleColumns());
        setColumnNames();
        setCaption("Список товара");
        setSizeFull();
        setHeight(400, Unit.POINTS);
        setSelectable(true);
        setImmediate(true);
        addListeners();
    }

    private void setColumnNames() {
        setColumnHeader(Product.ID, "№");
        setColumnWidth(Product.ID, 30);
        setColumnHeader(Product.ARTIKUL, "Артикул");
        setColumnWidth(Product.ARTIKUL, 80);
        setColumnHeader(Product.PRICE, "Цена (грн)");
        setColumnWidth(Product.PRICE, 80);
        setColumnHeader(Product.NAME, "Имя товара");
        setColumnWidth(Product.NAME, 200);
        setColumnHeader(Product.GROUP_NAME, "Группа товара");
        setColumnWidth(Product.GROUP_NAME, 150);
        setColumnHeader(Product.DESCRIPTION, "Описание товара");
    }

    private void addListeners() {
        LOG.debug("Added ItemClickListener {} to {}", model, this);
        addItemClickListener(model);
    }
}
