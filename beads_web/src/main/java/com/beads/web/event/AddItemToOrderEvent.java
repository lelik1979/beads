package com.beads.web.event;

/**
 * Created by alexey.dranchuk on 14.09.14.
 *
 */

public class AddItemToOrderEvent {

    private Integer productId;

    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
