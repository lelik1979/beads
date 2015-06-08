package com.beads.web.domain;

import com.beads.model.domain.Product;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexey.dranchuk on 12.09.14.
 *
 */

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCard implements Serializable {

    private List<ShoppingCardItem> items = new LinkedList<>();

    public void addItem(ShoppingCardItem item) {
        items.add(item);
    }

    public void deleteItem(final Product product) {
        Iterables.removeIf(items, new Predicate<ShoppingCardItem>() {
            @Override
            public boolean apply(ShoppingCardItem input) {
                return input.getProduct().equals(product);
            }
        });
    }

    public int getSize() {
        return items.size();
    }

    public List<ShoppingCardItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCardItem> items) {
        this.items = items;
    }

    public void addItem(Product product, Integer quantity) {
        items.add(new ShoppingCardItem(product, quantity));
    }

    protected BigDecimal calculateShopingCardPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for(ShoppingCardItem item : items) {
            result = result.add(item.calculateItemPrice());
        }
        return result;
    }

    public BigDecimal getShopingCardPrice() {
        return calculateShopingCardPrice();
    }
}
