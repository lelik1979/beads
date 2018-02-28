package com.beads.model.dao;

import com.beads.model.domain.Product;
import com.beads.model.domain.ProductComment;
import java.util.List;

public interface ProductCommentDao {

  /**
   * This method save comment for product,
   * if comment with same parameter exist it will be updated.
   *
   * @param productComment which must be save
   *
   * @return id of saved comment
   */
  int saveOrUpdateComment(ProductComment productComment);

  /**
   * This method load comment by commentId.
   *
   * @param id which need load
   *
   * @return loaded comment
   */
  ProductComment getCommentById(Integer id);

  /**
   * This method load all VISIBLE comment for product which passed to parameters.
   *
   * @param product for which need to load comments
   *
   * @return list visible comments for product;
   */
  List<ProductComment> loadVisibleCommentsForProduct(Product product);

  /**
   * This method load all comments with status INVISIBLE.
   *
   * @return list all comments with status INVISIBLE
   */
  List<ProductComment> getAllInvisibleComments();

  /**
   * This method remove comment which passed to parameters.
   *
   * @param productComment comment which must be deleted
   */
  void removeComment(ProductComment productComment);
}
