package com.lena.vaadin.view.product.component;

import com.lena.domain.Product;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
@Component
public class ProductWindowModel {

    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
