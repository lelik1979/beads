package com.beads.web.webcontroller;

import com.beads.model.dao.ProductDao;
import com.beads.model.domain.Order;
import com.beads.web.dao.ProductDaoImpl;
import com.beads.web.event.AddItemToOrderEvent;
import com.beads.web.event.RemoveItemToOrderEvent;
import com.beads.web.domain.ShoppingCard;
import com.beads.model.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * Created by alexey.dranchuk on 25.08.14.
 *
 */
@Controller
public class OrderController {

    public static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    public static final String OK = "ok";

    @Autowired
    private ShoppingCard shoppingCard;

    @Resource(name = ProductDaoImpl.BEAN_NAME)
    private ProductDao productDao;

    @RequestMapping(value = "/addItemToOrder", method = RequestMethod.PUT)
    @ResponseBody
    public String  addItemToOrder(@RequestBody AddItemToOrderEvent event) {
        Product product = productDao.loadProductById(event.getProductId());
        shoppingCard.addItem(product, event.getQuantity());
        LOG.debug("Product [{}] with quantity [{}] has been added to basket", product, event.getQuantity());
        return OK;
    }

    @RequestMapping(value = "/deleteItemFromBasket", method = RequestMethod.PUT)
    @ResponseBody
    public String  deleteItemFromBasket(@RequestBody RemoveItemToOrderEvent event) {
        Product product = productDao.loadProductById(event.getProductId());
        shoppingCard.deleteItem(product);
        LOG.debug("Product {} has been removed from the basket", product);
        return "ok";
    }


    @ModelAttribute("order")
    public Order getOrder() {
        return new Order();
    }

    @RequestMapping(value = "/showBasket", method = RequestMethod.GET)
    public String getMainData(Model model) {
        LOG.trace("showBasketState");
        BasketPageModel bpm = new BasketPageModel();
        bpm.setProducts(shoppingCard.getItems());
        bpm.setBasketSize(shoppingCard.getSize());
        model.addAttribute("model", bpm);
        return "/basket";
    }

}
