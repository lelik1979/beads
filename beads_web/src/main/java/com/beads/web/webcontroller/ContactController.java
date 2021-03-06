package com.beads.web.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author alexey.dranchuk
 */
@Controller

public class ContactController {

    public static final String CONTACT_URL = "/contact";

    @RequestMapping(value = CONTACT_URL, method = RequestMethod.GET)
    public String getMainData(Model model) {
        return CONTACT_URL;
    }

}
