package com.beads.model.dao;

import com.beads.model.domain.Product;
import com.beads.model.domain.ProductComment;
import java.util.List;

public interface ProductCommentDao {

  int saveOrUpdateComment(ProductComment productComment);

  ProductComment loadCommentById(Integer id);

  List<ProductComment> loadVisibleCommentsForProduct(Product product);

  List<ProductComment> getAllInvisibleComments();

  void removeComment(ProductComment productComment);
}
