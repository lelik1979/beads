package com.beads.web.dao;

import static com.beads.model.builder.ProductPersistentBuilder.PRODUCT_PERSISTENT_BUILDER;
import static com.beads.web.dao.OrderDaoImpl.BEAN_NAME;
import com.beads.model.builder.OrderBuilder;
import com.beads.model.builder.ProductPersistentBuilder;
import com.beads.model.domain.Order;
import com.beads.model.domain.OrderItem;
import com.beads.model.domain.OrderStatus;
import com.beads.model.domain.Product;
import com.beads.web.BaseIntegrationTest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOrderDaoImpl extends BaseIntegrationTest {

  @Resource(name = BEAN_NAME)
  private OrderDao orderDao;

  @Resource(name = PRODUCT_PERSISTENT_BUILDER)
  private ProductPersistentBuilder productPersistentBuilder;

  private OrderBuilder orderBuilder;
  private SearchCriteria searchCriteria;

  @Before
  public void init() {
    orderBuilder = new OrderBuilder();
    searchCriteria = new SearchCriteria();
  }

  @Test
  public void testSearchCriteriaWithOrderIdAndEmail() {
    List<OrderItem> orderItems = createOrderItems();
    String email = "vovan@gmail.com";
    Order expectedOrder = orderBuilder.withId(null)
        .withEmail(email).withOrderItems(orderItems).build();
    orderDao.saveOrUpdate(expectedOrder);

    searchCriteria.setOrderId(expectedOrder.getId());
    searchCriteria.setEmail("v");

    assertOrderBySearchCriteria(expectedOrder);
  }

  @Test
  public void testSearchCriteriaWithOrderStatusAndAddress() {
    List<OrderItem> orderItems = createOrderItems();
    String address = "Odessa";
    Order expectedOrder = orderBuilder.withId(null).withDeliveryAddress(address)
        .withStatus(OrderStatus.ERROR).withOrderItems(orderItems).build();
    orderDao.saveOrUpdate(expectedOrder);

    searchCriteria.setAddress("Od");
    searchCriteria.setStatus(OrderStatus.ERROR);

    assertOrderBySearchCriteria(expectedOrder);
  }

  @Test
  public void testSearchCriteriaWithOrderStatusAndPhoneNumber() {
    List<OrderItem> orderItems = createOrderItems();
    String phoneNumber = "+38097324324";
    Order expectedOrder = orderBuilder.withId(null).withPhoneNumber(phoneNumber)
        .withStatus(OrderStatus.COMPLETE).withOrderItems(orderItems).build();
    orderDao.saveOrUpdate(expectedOrder);

    searchCriteria.setPhoneNumber("+3");
    searchCriteria.setStatus(OrderStatus.COMPLETE);

    assertOrderBySearchCriteria(expectedOrder);
  }

  private void assertOrderBySearchCriteria(Order expectedOrder) {
    List<Order> orders = orderDao.getOrdersBySearchCriteria(searchCriteria);
    Order actualOrder = orders.get(0);
    Assert.assertEquals("Actual result must be expected", actualOrder, expectedOrder);
  }

  private List<OrderItem> createOrderItems() {
    Product product = productPersistentBuilder.buildAndAddProduct();
    OrderItem orderItem = new OrderItem();
    orderItem.setProduct(product);
    orderItem.setQuantity(2);
    List<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItem);
    return orderItems;
  }
}
