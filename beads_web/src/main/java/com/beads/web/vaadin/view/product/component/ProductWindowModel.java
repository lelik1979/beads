package com.beads.web.vaadin.view.product.component;

import com.beads.model.dao.ProductDao;
import com.beads.model.dao.ProductPhotoDao;
import com.beads.model.domain.Product;
import com.beads.model.domain.ProductGroupView;
import com.beads.web.vaadin.listener.EventBus;
import com.beads.web.vaadin.components.BeadsButtonModel;
import com.beads.web.vaadin.view.product.listener.ProductChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
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
