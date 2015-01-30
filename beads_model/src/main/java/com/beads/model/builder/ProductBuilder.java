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
        product = new Product(1, "productName");
        withDescription("product description");
        withPrice(BigDecimal.valueOf(123.32));
        withProductCode("ZSKD");
    }

    public ProductBuilder withProductCode(String productCode) {
        product.setProductCode(productCode);
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
