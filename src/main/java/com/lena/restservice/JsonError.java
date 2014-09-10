package com.lena.restservice;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.HashMap;
import java.util.Map;

public class JsonError {

    private Map<String, String> errors;

    public JsonError(String errorMessage, String stackTrace) {
        errors = new HashMap<String, String>();
        errors.put("error", errorMessage);
        errors.put("errorStackTrace", stackTrace);
    }

    public ModelAndView asModelAndView() {
        MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
        return new ModelAndView(jsonView, errors);
    }

}
