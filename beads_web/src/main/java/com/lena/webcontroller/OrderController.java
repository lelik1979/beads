package com.lena.webcontroller;

import com.beads.model.domain.Order;
import com.lena.domain.ShoppingCard;
import com.beads.model.domain.Product;
import com.lena.event.AddItemToOrderEvent;
import com.lena.event.RemoveItemToOrderEvent;
import com.lena.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alexey.dranchuk on 25.08.14.
 *
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

    @RequestMapping(value = "/deleteItemFromBasket", method = RequestMethod.PUT)
    @ResponseBody
    public String  deleteItemFromBasket(@RequestBody RemoveItemToOrderEvent event) {
        Product product = productService.findProductById(event.getProductId());
        shoppingCard.deleteProduct(product);
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
        bpm.setProducts(shoppingCard.getProducts());
        bpm.setBasketSize(shoppingCard.getSize());
        model.addAttribute("model", bpm);
        return "/basket";
    }

}
