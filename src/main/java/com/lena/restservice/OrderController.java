package com.lena.restservice;

import com.lena.domain.Order;
import com.lena.domain.Product;
import com.lena.event.AddItemToOrderEvent;
import com.lena.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 25.08.14.
 */
@RestController
public class OrderController {

    public static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private Order order;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addItemToOrder", method = RequestMethod.POST)
    @ResponseBody
    public String  addItemToOrder(AddItemToOrderEvent event) {
        Product product = productService.findProductById(event.getProductId());
        order.addProduct(product);
        return "redirect:/";
    }

    @ModelAttribute("order")
    public Order getOrder() {
        return order;
    }
}
