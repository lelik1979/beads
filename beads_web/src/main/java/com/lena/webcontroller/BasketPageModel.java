package com.lena.webcontroller;

import com.beads.model.domain.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.11.14.
 *
 */
public class BasketPageModel {

    private List<Product> products;

    private Integer basketSize;

    public Integer getBasketSize() {
        return basketSize;
    }

    public void setBasketSize(Integer basketSize) {
        this.basketSize = basketSize;
    }

    public BigDecimal getTotalPrice() {
        return calculateTotalPrice();
    }

    protected BigDecimal calculateTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Product p : getProducts()) {
            total = total.add(p.getPrice());
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
