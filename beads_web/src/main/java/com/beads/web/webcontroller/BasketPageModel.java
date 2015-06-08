package com.beads.web.webcontroller;

import com.beads.web.domain.ShoppingCardItem;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.11.14.
 *
 */
public class BasketPageModel {

    private List<ShoppingCardItem> items;

    private Integer basketSize;

    public Integer getBasketSize() {
        return basketSize;
    }

    public void setBasketSize(Integer basketSize) {
        this.basketSize = basketSize;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (ShoppingCardItem item : items) {
            result = result.add(item.getItemPrice());
        }
        return result;
    }


    public List<ShoppingCardItem> getItems() {
        return items;
    }

    public void setProducts(List<ShoppingCardItem> products) {
        this.items = products;
    }
}
