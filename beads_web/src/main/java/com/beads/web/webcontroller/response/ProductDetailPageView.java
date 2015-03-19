package com.beads.web.webcontroller.response;

import com.beads.model.domain.Product;

/**
 * @author alexey.dranchuk
 */
public class ProductDetailPageView extends BasePageView {

    private Product product;

    @Override
    public int getSize() {
        return 1;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
