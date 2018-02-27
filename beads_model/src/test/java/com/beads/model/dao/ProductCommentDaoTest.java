package com.beads.model.dao;

import static com.beads.model.builder.ProductPersistentBuilder.PRODUCT_PERSISTENT_BUILDER;
import com.beads.model.builder.ProductCommentBuilder;
import com.beads.model.builder.ProductPersistentBuilder;
import com.beads.model.constant.CommentStatus;
import com.beads.model.domain.Product;
import com.beads.model.domain.ProductComment;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCommentDaoTest extends CommonDaoIT {

  @Resource(name = PRODUCT_PERSISTENT_BUILDER)
  private ProductPersistentBuilder productPersistentBuilder;

  @Autowired
  private ProductCommentDao productCommentDao;

  private ProductCommentBuilder productCommentBuilder;


  @Before
  public void init() {
    productCommentBuilder = new ProductCommentBuilder();
  }

  @Test
  public void testSaveCommentAndLoadCommentById() {
    Product product = productPersistentBuilder.buildAndAddProduct();
    ProductComment expectedProductComment = productCommentBuilder.withProduct(product).build();
    productCommentDao.saveOrUpdateComment(expectedProductComment);

    ProductComment actualProductComment = productCommentDao.loadCommentById(expectedProductComment.getId());

    Assert.assertEquals("Actual result must be expected", actualProductComment, expectedProductComment);
  }

  @Test
  public void testGetAllInvisibleComments() {
    Product product = productPersistentBuilder.buildAndAddProduct();
    ProductComment expectedProductComment = productCommentBuilder
        .withProduct(product).build();
    productCommentDao.saveOrUpdateComment(expectedProductComment);

    productCommentBuilder.reset();

    ProductComment productCommentWitStatusVisible = productCommentBuilder
        .withProduct(product).withCommentStatus(CommentStatus.VISIBLE).build();
    productCommentDao.saveOrUpdateComment(productCommentWitStatusVisible);

    List<ProductComment> productComments = productCommentDao.getAllInvisibleComments();

    Assert.assertTrue("List productComments size must be 1", (productComments.size() == 1));
    Assert.assertEquals("Actual result must be expected",
        productComments.get(0), expectedProductComment);
  }
}
