package com.lena.vaadin.view.product.component;

import com.lena.dao.ProductDao;
import com.lena.dao.ProductPhotoDao;
import com.lena.domain.Product;
import com.lena.domain.ProductGroupView;
import com.lena.vaadin.components.BeadsButtonModel;
import com.lena.vaadin.listener.EventBus;
import com.lena.vaadin.view.product.listener.ProductChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class ProductWindowModel {

    private Product product;

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductPhotoDao productPhotoDao;

    private File uploadedFile;

    @Autowired
    private BeadsButtonModel saveButtonModel;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setUploadedFile(File uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public List<ProductGroupView> loadProductGroupViews() {
        return productDao.loadAllProductGroupView();
    }

    public void saveProduct() {
        productDao.saveOrUpdate(product);
        if (uploadedFile != null) {
            productPhotoDao.saveOrUpdate(product.buildProductPhoto(PhotoConvertor.convertImage(uploadedFile)));
            uploadedFile.delete();
            uploadedFile = null;
        }
        eventBus.fireEvent(new ProductChangeEvent(product));
    }

    public BeadsButtonModel getSaveButtonModel() {
        return saveButtonModel;
    }
}
