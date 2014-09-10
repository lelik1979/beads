package com.lena.restservice;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 25.08.14.
 */
@Controller
public class RestService {

        public static final Logger LOG = LoggerFactory.getLogger(RestService.class);

    @RequestMapping(value = "/rest1", method = RequestMethod.GET)
    public
    @ResponseBody
    JsonObject getData(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "name") String name) {
        return new JsonObject(Integer.parseInt(id), name);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleExceptions(Exception ex) {
        LOG.error("There was an error during processing webservice", ex);
        String stackTrace = ExceptionUtils.getStackTrace(ex);
        return new JsonError(ex.getMessage(), stackTrace).asModelAndView();
    }
}
