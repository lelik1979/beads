package com.beads.model.dao;

import com.beads.model.domain.ProductComment;
import java.util.List;

public interface ProductCommentDao {

  int saveOrUpdateComment(ProductComment productComment);

  ProductComment loadCommentById(Integer id);

  List<ProductComment> getAllComments();

  List<ProductComment> getAllInvisibleComments();

  void removeComment(ProductComment productComment);
}
