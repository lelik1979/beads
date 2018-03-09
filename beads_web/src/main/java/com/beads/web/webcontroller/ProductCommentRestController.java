package com.beads.web.webcontroller;

import com.beads.model.dao.ProductCommentDao;
import com.beads.model.domain.ProductComment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCommentRestController {

  @Autowired
  private ProductCommentDao productCommentDao;

  @RequestMapping(value = "/comment/{productId}", method = RequestMethod.GET)
  List<ProductComment> getAllCommentForProduct(@PathVariable("productId") Integer productId) {
    return productCommentDao.loadVisibleCommentsForProduct(productId);
  }
}
