package com.beads.web.restcontroller;

import com.beads.model.dao.ProductCommentDao;
import com.beads.model.domain.Product;
import com.beads.model.domain.ProductComment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCommentRestController {

  @Autowired
  private ProductCommentDao productCommentDao;

  @RequestMapping(value = "/comment", method = RequestMethod.POST)
  List<ProductComment> getAllCommentForProduct(@RequestBody Product product) {
    return productCommentDao.loadVisibleCommentsForProduct(product);
  }
}
