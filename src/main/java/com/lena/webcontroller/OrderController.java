package com.lena.webcontroller;

import com.lena.domain.Order;
import com.lena.domain.ShoppingCard;
import com.lena.domain.Product;
import com.lena.event.AddItemToOrderEvent;
import com.lena.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 25.08.14.
 */
@Controller
public class OrderController {

    public static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ShoppingCard shoppingCard;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addItemToOrder", method = RequestMethod.PUT)
    @ResponseBody
    public String  addItemToOrder(@RequestBody AddItemToOrderEvent event) {
        Product product = productService.findProductById(event.getProductId());
        shoppingCard.addProduct(product);
        LOG.debug("Product = {} has been added to basket", product);
        return "ok";
    }

    @ModelAttribute("order")
    public Order getOrder() {
        return new Order();
    }

    @RequestMapping(value = "/showBasket", method = RequestMethod.GET)
    public String getMainData(Model model) {
        LOG.trace("showBasketState");
        model.addAttribute("products", shoppingCard.getProducts());
        model.addAttribute("shoppingCardSize", shoppingCard.getSize());
        return "/basket";
    }

}
