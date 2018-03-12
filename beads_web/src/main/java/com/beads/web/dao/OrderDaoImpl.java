package com.beads.web.dao;

import com.beads.model.domain.Order;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(OrderDaoImpl.BEAN_NAME)
@Primary
public class OrderDaoImpl extends com.beads.model.dao.OrderDaoImpl implements OrderDao {

  public static final String BEAN_NAME = "web.OrderDaoImpl";

  private List<Predicate> predicates = new ArrayList<>();

  @Override
  public List<Order> getOrdersBySearchCriteria(SearchCriteria searchCriteria) {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    Root<Order> root = criteriaQuery.from(Order.class);
    root.fetch(Order.ORDER_ITEMS);
    List<Predicate> predicates1 = buildSearchPredicate(criteriaBuilder, root, searchCriteria);
    Predicate[] predicates = predicates1.toArray(new Predicate[predicates1.size()]);
    criteriaQuery.select(root);
    if (predicates.length != 0) {
      criteriaQuery.where(criteriaBuilder.and(predicates));
    }
    return getSession().createQuery(criteriaQuery).setMaxResults(MAX_ROW_RESULT).list();
  }

  private List<Predicate> buildSearchPredicate(CriteriaBuilder criteriaBuilder,Root<Order> root, SearchCriteria searchCriteria) {
    predicates.clear();
    if (searchCriteria.isOrderIdNotNull()) {
      predicates.add(criteriaBuilder.equal(root.get(Order.ID), searchCriteria.getOrderId()));
    }
    if (searchCriteria.isEmailNotNull()) {
      predicates.add(criteriaBuilder.like(root.get(Order.EMAIL), searchCriteria.getEmail() + "%"));
    }
    if (searchCriteria.isStatusNotNull()) {
      predicates.add(criteriaBuilder.equal(root.get(Order.STATUS), searchCriteria.getStatus()));
    }
    if (searchCriteria.isPhoneNumberNotNull()) {
      predicates.add(criteriaBuilder.like(root.get(Order.PHONE_NUMBER), searchCriteria.getPhoneNumber() + "%"));
    }
    if (searchCriteria.isAddressNotNull()) {
      predicates.add(criteriaBuilder.like(root.get(Order.DELIVERY_ADDRESS), "%" + searchCriteria.getAddress() + "%"));
    }
    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Order.MODIFIED_DATE), searchCriteria.getDateOfOrder()));
    return predicates;
  }
}
