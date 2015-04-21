package com.beads.web.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author alexey.dranchuk
 */
@Controller

public class PaymentController {

    public static final String PAYMENT_PAGE = "payment";

    public static final String PAYMENT_URL = "/" + PAYMENT_PAGE;

    @RequestMapping(value = PAYMENT_URL, method = RequestMethod.GET)
    public String getMainData(Model model) {
        return PAYMENT_PAGE;
    }

}
