package com.beads.web.domain;

import com.beads.model.domain.Product;
import java.math.BigDecimal;

public class ShoppingCardItem {

    private Product product;

    private int quantity;

    public ShoppingCardItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected BigDecimal calculateItemPrice() {
        return BigDecimal.valueOf(getQuantity()).multiply(getProduct().getPrice());
    }

    public BigDecimal getItemPrice() {
        return calculateItemPrice();
    }

}

