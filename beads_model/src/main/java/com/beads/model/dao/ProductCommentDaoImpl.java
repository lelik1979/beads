package com.beads.model.dao;

import com.beads.model.constant.CommentStatus;
import com.beads.model.domain.ProductComment;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCommentDaoImpl extends BaseDao implements ProductCommentDao {

  @Override
  public int saveOrUpdateComment(ProductComment productComment) {
    getSession().saveOrUpdate(productComment);
    return productComment.getId();
  }

  @Override
  public ProductComment loadCommentById(Integer id) {
    return (ProductComment) getSession().get(ProductComment.class, id);
  }

  @Override
  public List<ProductComment> getAllComments() {
    Criteria criteria = getSession().createCriteria(ProductComment.class);
    criteria.setMaxResults(MAX_ROW_RESULT);
    return criteria.list();
  }

  @Override
  public List<ProductComment> getAllInvisibleComments() {
    Criteria criteria = getSession().createCriteria(ProductComment.class);
    criteria.add(Restrictions.eq(ProductComment.STATUS, CommentStatus.INVISIBLE));
    criteria.setMaxResults(MAX_ROW_RESULT);
    return criteria.list();
  }

  @Override
  public void removeComment(ProductComment productComment) {
      getSession().delete(productComment);
  }
}
