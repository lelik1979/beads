package com.lena.webcontroller.response;

import com.lena.domain.Product;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 30.09.14.
 */
public class ProductView {

    private List<Product> products = new LinkedList<Product>();

    private String searchString;

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
}
