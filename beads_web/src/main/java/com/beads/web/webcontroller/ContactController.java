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

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getMainData(Model model) {
        return "/contact";
    }

}
