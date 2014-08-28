package com.lena.webcontroller;

import com.lena.service.RazdelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 25.08.14.
 */
@Controller
public class WebController {

    public static final Logger LOG = LoggerFactory.getLogger(WebController.class);

    private RazdelService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getMainData() {
        LOG.trace("getMainData");
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("razdels", service.findAllRazdels());
        return mv;
    }

    @Autowired
    public void setService(RazdelService service) {
        this.service = service;
    }

}
