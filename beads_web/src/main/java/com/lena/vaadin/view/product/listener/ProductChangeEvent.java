package com.lena.vaadin.view.product.listener;

import com.github.wolfie.blackboard.Event;
import com.github.wolfie.blackboard.Listener;
import com.beads.model.domain.Product;

/**
 * Created by alexey.dranchuk on 10/1/15.
 *
 */
public class ProductChangeEvent implements Event {

    private Product product;

    public ProductChangeEvent(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public interface ProductChangeListner extends Listener {
        public void fireProductChange(ProductChangeEvent event);

    }
}
