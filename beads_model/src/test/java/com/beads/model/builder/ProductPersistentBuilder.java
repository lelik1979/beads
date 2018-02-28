package com.beads.model.builder;

import static com.beads.model.builder.ProductPersistentBuilder.PRODUCT_PERSISTENT_BUILDER;
import com.beads.model.dao.ProductDao;
import com.beads.model.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(PRODUCT_PERSISTENT_BUILDER)
public class ProductPersistentBuilder {

  public static final String PRODUCT_PERSISTENT_BUILDER = "productPersistentBuilder";

  @Autowired
  private ProductDao productDao;
  private ProductBuilder productBuilder;

  public Product buildAndAddProduct() {
    productBuilder = new ProductBuilder();
    Product product = productBuilder.build();
    productDao.saveOrUpdate(product);
    return product;
  }
}
