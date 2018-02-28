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
  public void testSaveComment() {
    Product product = productPersistentBuilder.buildAndAddProduct();
    ProductComment expectedProductComment = productCommentBuilder.withProduct(product).build();
    productCommentDao.saveOrUpdateComment(expectedProductComment);

    ProductComment actualProductComment = productCommentDao.getCommentById(expectedProductComment.getId());

    Assert.assertEquals("Actual result must be expected", actualProductComment, expectedProductComment);
  }

  @Test
  public void testGetAllInvisibleComments() {
    Product product = productPersistentBuilder.buildAndAddProduct();
    ProductComment expectedProductComment =
        createAndSaveComment(product, CommentStatus.INVISIBLE);

    productCommentBuilder.reset();

    createAndSaveComment(product, CommentStatus.VISIBLE);

    List<ProductComment> productComments = productCommentDao.getAllInvisibleComments();

    Assert.assertTrue("List productComments size must be 1", (productComments.size() == 1));
    Assert.assertEquals("Actual result must be expected",
        productComments.get(0), expectedProductComment);
  }

  @Test
  public void testRemoveComment() {
    Product product = productPersistentBuilder.buildAndAddProduct();
    ProductComment productComment = createAndSaveComment(product, CommentStatus.INVISIBLE);
    productCommentDao.removeComment(productComment);

    ProductComment actualComment = productCommentDao.getCommentById(productComment.getId());

    Assert.assertTrue("Actual comment must be null", actualComment == null);
  }

  @Test
  public void loadVisibleCommentsForProduct() {
    Product firstProduct = productPersistentBuilder.buildAndAddProduct();
    Product secondProduct = productPersistentBuilder.buildAndAddProduct();

    createAndSaveComment(firstProduct, CommentStatus.INVISIBLE);
    productCommentBuilder.reset();

    createAndSaveComment(secondProduct, CommentStatus.INVISIBLE);
    productCommentBuilder.reset();

    ProductComment expectedComment = createAndSaveComment(secondProduct, CommentStatus.VISIBLE);

    List<ProductComment> commentsForProduct = productCommentDao.loadVisibleCommentsForProduct(secondProduct);

    Assert.assertTrue("List productComments size must be 1", (commentsForProduct.size() == 1));

    Assert.assertEquals("Actual result must be expected",
        commentsForProduct.get(0), expectedComment);
  }

  private ProductComment createAndSaveComment(Product product, CommentStatus status) {
    ProductComment comment = productCommentBuilder
        .withProduct(product)
        .withCommentStatus(status)
        .build();
    productCommentDao.saveOrUpdateComment(comment);
    return comment;
  }
}
