package com.beads.web.webcontroller;

import com.beads.model.domain.OrderItem;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.11.14.
 *
 */
public class BasketPageModel {

    private List<OrderItem> items;

    private Integer basketSize;

    public Integer getBasketSize() {
        return basketSize;
    }

    public void setBasketSize(Integer basketSize) {
        this.basketSize = basketSize;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (OrderItem item : items) {
            result = result.add(item.calculateCost());
        }
        return result;
    }


    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
