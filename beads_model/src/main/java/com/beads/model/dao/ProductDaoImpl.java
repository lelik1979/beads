package com.beads.model.dao;

import com.beads.model.domain.Product;
import com.beads.model.domain.ProductGroupView;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by alexey.dranchuk on 13.09.14.
 *
 */
@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> loadProducts() {
        Criteria crt = getSession().createCriteria(Product.class);
        crt.addOrder(Order.desc(Product.ID));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    @Override
    public Product loadProductById(Integer id) {
        return (Product) getSession().get(Product.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> searchProductBySearchString(String searchString) {
        Criteria crt = getSession().createCriteria(Product.class);
        crt.add(buildSearchRestriction(searchString));
        crt.addOrder(Order.desc(Product.ID));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> loadProductByGroupId(Integer groupId) {
        Criteria crt = getSession().createCriteria(Product.class);
        crt.add(Restrictions.eq(Product.GROUP_ID, groupId));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductGroupView> loadAllProductGroupView() {
        Criteria crt = getSession().createCriteria(ProductGroupView.class);
        crt.add(Restrictions.isNotNull(ProductGroupView.PARENT_ID));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    @Override
    public void saveOrUpdate(Product product) {
        getSession().saveOrUpdate(product);
    }

    @Override
    public void removeProduct(Product product) {
        Query query = getSession().createQuery("delete from ProductPhoto where id = :id ");
        query.setInteger("id", product.getId());
        query.executeUpdate();
        getSession().delete(product);
    }

    private Criterion buildSearchRestriction(String searchString) {
        Disjunction dj = Restrictions.disjunction();
        dj.add(Restrictions.ilike(Product.NAME, searchString, MatchMode.ANYWHERE));
        dj.add(Restrictions.ilike(Product.DESCRIPTION, searchString, MatchMode.ANYWHERE));
        dj.add(Restrictions.ilike(Product.ARTIKUL, searchString, MatchMode.ANYWHERE));
        return dj;
    }
}
