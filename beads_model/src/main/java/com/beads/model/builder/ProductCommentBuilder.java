package com.beads.model.builder;

import com.beads.model.constant.CommentStatus;
import com.beads.model.domain.Product;
import com.beads.model.domain.ProductComment;

public class ProductCommentBuilder {

  private ProductComment productComment;

  public ProductCommentBuilder() {
    init();
  }

  public void init() {
    productComment = new ProductComment();
    withProduct(new Product());
    withComment("Some comment for product");
    withRating(45);
  }

  public ProductCommentBuilder withId(Integer id) {
    productComment.setId(id);
    return this;
  }

  public ProductCommentBuilder withProduct(Product product) {
    productComment.setProduct(product);
    return this;
  }

  public ProductCommentBuilder withComment(String comment) {
    productComment.setComment(comment);
    return this;
  }

  public ProductCommentBuilder withDisadvantages(String disadvantages) {
    productComment.setDisadvantages(disadvantages);
    return this;
  }

  public ProductCommentBuilder withAdvantages(String advantages) {
    productComment.setAdvantages(advantages);
    return this;
  }

  public ProductCommentBuilder withCommentStatus(CommentStatus commentStatus) {
    productComment.setStatus(commentStatus);
    return this;
  }

  public ProductCommentBuilder withRating(Integer rating) {
    productComment.setRating(rating);
    return this;
  }

  public ProductComment build() {
    return productComment;
  }

  public void reset() {
    init();
  }
}
