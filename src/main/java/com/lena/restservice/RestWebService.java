package com.lena.restservice;

import com.lena.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 25.08.14.
 */
@RestController
public class RestWebService {

    public static final Logger LOG = LoggerFactory.getLogger(RestWebService.class);

    @Autowired
    private Order order;

    @RequestMapping(value = "/rest1", method = RequestMethod.GET)
    @ResponseBody
    public String  getData() {
        return "id=";
    }

    @ModelAttribute("order")
    public Order getOrder() {
        return order;
    }
}
