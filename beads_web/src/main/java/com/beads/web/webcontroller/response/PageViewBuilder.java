package com.beads.web.webcontroller.response;

import com.beads.model.dao.ProductDao;
import com.beads.model.dao.ProductGroupDao;
import com.beads.web.dao.ProductDaoImpl;
import com.beads.web.dao.ProductGroupDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import javax.annotation.Resource;

@Service
public class PageViewBuilder {

    @Resource(name = ProductDaoImpl.BEAN_NAME)
    private ProductDao productDao;

    @Resource(name = ProductGroupDaoImpl.BEAN_NAME)
    private ProductGroupDao productGroupDao;

    public void populateProductDetailView(Model model, int productId) {
        ProductDetailPageView pv = new ProductDetailPageView();
        pv.setProduct(productDao.loadProductById(productId));
        populateProductGroups(pv);
        model.addAttribute("pv", pv);
    }

    private <T extends BasePageView> void populateProductGroups(T pageView) {
        pageView.setCategories(productGroupDao.findAllProductGroup());
    }
}