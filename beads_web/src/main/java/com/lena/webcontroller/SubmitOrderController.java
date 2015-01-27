package com.lena.webcontroller;

import com.lena.dao.OrderDao;
import com.lena.domain.Order;
import com.lena.domain.ShoppingCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 28.09.14.
 */
@Controller
public class SubmitOrderController {

    public static final Logger LOG = LoggerFactory.getLogger(SubmitOrderController.class);

    @Autowired
    private ShoppingCard shoppingCard;

    @Autowired
    private OrderDao orderDao;


    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
    public String submitOrder(Order order, Model model) {
        order.setProducts(shoppingCard.getProducts());
        orderDao.saveOrUpdate(order);
        LOG.debug("Order with id={} has been submitted", order.getId());
        resetShoppingCard();
        model.addAttribute("order", order);
        return "/result";
    }

    private void resetShoppingCard() {
        ((ScopedObject) shoppingCard).removeFromScope();
    }

}
