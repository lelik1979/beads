package com.beads.model.builder;

import com.beads.model.domain.OrderItem;
import com.beads.model.domain.Product;


/**
 * Created by alexey.dranchuk on 29/1/15.
 *
 */
public class OrderItemBuilder {

    private OrderItem orderItem;

    private ProductBuilder productBuilder = new ProductBuilder();

    public OrderItemBuilder() {
        initDefault();
    }

    private void initDefault() {
        orderItem = new OrderItem(1, productBuilder.build());
        withId(1);
    }

    public OrderItemBuilder withQuantity(int quantity) {
        orderItem.setQuantity(quantity);
        return this;
    }

    public OrderItemBuilder withProduct(Product product) {
        orderItem.setProduct(product);
        return this;
    }

    public OrderItemBuilder withId(Integer id) {
        orderItem.setId(1);
        return this;
    }

    public OrderItem build() {
        return orderItem;
    }

    public void reset() {
        initDefault();
    }
}
