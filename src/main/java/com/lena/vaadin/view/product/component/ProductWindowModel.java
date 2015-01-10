package com.lena.vaadin.view.product.component;

import com.lena.dao.ProductDao;
import com.lena.domain.Product;
import com.lena.domain.ProductGroupView;
import com.lena.vaadin.listener.EventBus;
import com.lena.vaadin.view.product.listener.ProductChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
@Component
public class ProductWindowModel {

    private Product product;

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ProductDao productDao;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }


    public List<ProductGroupView> loadProductGroupViews() {
        return productDao.loadAllProductGroupView();
    }

    public void saveProduct() {
        productDao.saveOrUpdate(product);
        eventBus.fireEvent(new ProductChangeEvent(product));
    }
}
