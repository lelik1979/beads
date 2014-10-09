package com.lena.dao;

import com.lena.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Administrator on 13.09.14.
 */
@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public List<Product> findAllProducts() {
        Criteria crt = getSession().createCriteria(Product.class);
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    @Override
    public Product loadProductById(Integer id) {
        return (Product) getSession().get(Product.class, id);
    }

    @Override
    public List<Product> searchProductBySearchString(String searchString) {
        Criteria crt = getSession().createCriteria(Product.class);
        crt.add(buildSearchRestriction(searchString));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    private Criterion buildSearchRestriction(String searchString) {
        Disjunction dj = Restrictions.disjunction();
        Integer id = parseToInteger(searchString);
        if (id != null) {
            dj.add(Restrictions.eq(Product.ID, id));
        }
        dj.add(Restrictions.ilike(Product.NAME, searchString, MatchMode.ANYWHERE));
        return dj;
    }

    private Integer parseToInteger(String searchString) {
        try {
            return Integer.valueOf(searchString);
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
