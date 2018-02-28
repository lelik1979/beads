package com.beads.model.dao;

import com.beads.model.constant.CommentStatus;
import com.beads.model.domain.Product;
import com.beads.model.domain.ProductComment;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCommentDaoImpl extends BaseDao implements ProductCommentDao {

  /**
   * This method save comment for product,
   * if comment with same parameter exist it will be updated.
   *
   * @param productComment which must be save
   *
   * @return id of saved comment
   */
  @Override
  public int saveOrUpdateComment(ProductComment productComment) {
    getSession().saveOrUpdate(productComment);
    return productComment.getId();
  }

  /**
   * This method load comment by commentId.
   *
   * @param id which need load
   *
   * @return loaded comment
   */
  @Override
  public ProductComment loadCommentById(Integer id) {
    return getSession().get(ProductComment.class, id);
  }

  /**
   * This method load all VISIBLE comment for product which passed to parameters.
   *
   * @param product for which need to load comments
   *
   * @return list visible comments for product;
   */
  @Override
  public List<ProductComment> loadVisibleCommentsForProduct(Product product) {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<ProductComment> query = criteriaBuilder.createQuery(ProductComment.class);
    Root<ProductComment> productCommentRoot = query.from(ProductComment.class);
    query
        .select(productCommentRoot)
        .where(criteriaBuilder.equal(productCommentRoot.get("product"), product),
            criteriaBuilder.equal(productCommentRoot.get(ProductComment.STATUS), CommentStatus.VISIBLE));
    return getSession().createQuery(query).setMaxResults(MAX_ROW_RESULT).list();
  }

  /**
   * This method load all comments with status INVISIBLE.
   *
   * @return list all comments with status INVISIBLE
   */
  @Override
  public List<ProductComment> getAllInvisibleComments() {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<ProductComment> query = criteriaBuilder.createQuery(ProductComment.class);
    Root<ProductComment> commentRoot = query.from(ProductComment.class);
    query
        .select(commentRoot)
        .where(criteriaBuilder.equal(commentRoot.get(ProductComment.STATUS), CommentStatus.INVISIBLE));
    return getSession().createQuery(query).setMaxResults(MAX_ROW_RESULT).list();
  }

  /**
   * This method remove comment which passed to parameters.
   *
   * @param productComment comment which must be deleted
   */
  @Override
  public void removeComment(ProductComment productComment) {
      getSession().delete(productComment);
  }
}
