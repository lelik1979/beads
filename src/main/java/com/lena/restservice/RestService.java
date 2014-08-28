package com.lena.restservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 25.08.14.
 */
@Controller
public class RestService {

@RequestMapping(value = "/rest1", method = RequestMethod.GET)
public @ResponseBody JsonObject getData(
        @RequestParam(value = "id") int id,
        @RequestParam(value = "name") String name) {
    return new JsonObject(id, name);
}
}
