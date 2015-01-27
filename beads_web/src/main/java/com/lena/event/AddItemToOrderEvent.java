package com.lena.event;

/**
 * Created by Administrator on 14.09.14.
 */
public class AddItemToOrderEvent {

    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
