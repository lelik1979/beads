package com.lena.webcontroller;

import com.lena.domain.Product;
import com.lena.domain.ShoppingCard;
import com.lena.service.ProductService;
import com.lena.webcontroller.response.ProductView;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 25.08.14.
 */
@Controller
public class ProductController {

    public static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCard shoppingCard;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainData(Model model) {
        LOG.trace("getMainData");
        return buildProductViewResponse(model, productService.findProducts(), null);
    }

    @RequestMapping(value="/searchProducts", method = RequestMethod.GET)
    public String searchProducts(Model model, String searchString) {
        List<Product> products;
        if (StringUtils.isEmpty(searchString)) {
            products = productService.findProducts();
        } else {
            products = productService.searchProductBySearchString(searchString);
        }
        return buildProductViewResponse(model, products, searchString);
    }

    private String buildProductViewResponse(Model model, List<Product> products, String searchString) {
        ProductView pv = new ProductView();
        pv.setProducts(products);
        pv.setSearchString(searchString);
        model.addAttribute("pv", pv);
        return "/main";
    }

    @ModelAttribute("order")
    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }
}
