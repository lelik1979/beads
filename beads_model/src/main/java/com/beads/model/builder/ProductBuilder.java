package com.beads.model.builder;

import com.beads.model.domain.Product;
import java.math.BigDecimal;

/**
 * Created by alexey.dranchuk on 29/1/15.
 *
 */
public class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        initDefault();
    }

    private void initDefault() {
        product = new Product();
        product.setName("productName1");
        withDescription("product description");
        withPrice(BigDecimal.valueOf(123.32));
        withArticul("ZSKD");
    }

    public ProductBuilder withArticul(String articul) {
        product.setArticul(articul);
        return this;
    }

    public ProductBuilder withPrice(BigDecimal price) {
        product.setPrice(price);
        return this;
    }

    public ProductBuilder withDescription(String description) {
        product.setDescription(description);
        return this;
    }

    public Product build() {
        return product;
    }

    public void reset() {
        initDefault();
    }
}
