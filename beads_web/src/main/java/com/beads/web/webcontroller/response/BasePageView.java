package com.beads.web.webcontroller.response;

import com.beads.model.domain.ProductGroup;

import java.util.List;

/**
 * @author alexey.dranchuk
 */
public abstract class BasePageView {

    private String searchString;

    private List<ProductGroup> categories;


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<ProductGroup> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductGroup> categories) {
        this.categories = categories;
    }

    public abstract int getSize();

}
