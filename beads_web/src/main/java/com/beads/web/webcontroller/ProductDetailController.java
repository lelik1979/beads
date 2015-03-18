package com.beads.web.webcontroller;

import com.beads.model.dao.ProductDao;
import com.beads.model.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;

/**
 * @author alexey.dranchuk
 */
@Controller
public class ProductDetailController {

    @Resource
    private ProductDao productDao;

    @RequestMapping(value = "/showProduct", method = RequestMethod.GET)
    public String getMainData(Model model, @RequestParam("id")int productId) {
        Product product = productDao.loadProductById(productId);
        model.addAttribute("product", product);
        return "/productView";
    }
}
