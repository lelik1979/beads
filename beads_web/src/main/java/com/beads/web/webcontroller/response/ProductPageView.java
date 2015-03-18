package com.beads.web.webcontroller.response;

import com.beads.model.domain.Product;
import com.beads.model.domain.ProductGroup;
import com.google.gwt.thirdparty.guava.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexey.dranchuk on 30.09.14.
 *
 */
public class ProductPageView {

    public static final int COLUMN_COUNT = 3;

    private List<Product> products = new LinkedList<>();

    private String searchString;

    private List<ProductGroup> categories;

    public List<ProductGroup> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductGroup> categories) {
        this.categories = categories;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public int getSize() {
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductTableList() {
        return Lists.partition(products, COLUMN_COUNT);
    }
}
