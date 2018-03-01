package com.beads.model.dao;

import com.beads.model.constant.CommentStatus;
import com.beads.model.domain.ProductComment;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCommentDaoImpl extends BaseDao implements ProductCommentDao {

  @Override
  public int saveOrUpdateComment(ProductComment productComment) {
    getSession().saveOrUpdate(productComment);
    return productComment.getId();
  }

  @Override
  public ProductComment getCommentById(Integer id) {
    return getSession().get(ProductComment.class, id);
  }

  @Override
  public List<ProductComment> loadVisibleCommentsForProduct(Integer productId) {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<ProductComment> query = criteriaBuilder.createQuery(ProductComment.class);
    Root<ProductComment> productCommentRoot = query.from(ProductComment.class);
    query
        .select(productCommentRoot)
        .where(criteriaBuilder.equal(productCommentRoot.get("product"), productId),
            criteriaBuilder.equal(productCommentRoot.get(ProductComment.STATUS), CommentStatus.VISIBLE));
    return getSession().createQuery(query).setMaxResults(MAX_ROW_RESULT).list();
  }

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

  @Override
  public void removeComment(ProductComment productComment) {
      getSession().delete(productComment);
  }
}
