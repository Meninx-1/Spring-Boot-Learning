package com.zetcode.controller;

import com.zetcode.exception.MyDataException;
import com.zetcode.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private IDataService dataService;

    @RequestMapping(value = "/getData")
    public ModelAndView getData() {

        var data = dataService.findAll();

        Map<String, Object> params = new HashMap<>();
        params.put("values", data);

        return new ModelAndView("showData", params);
    }

    @ExceptionHandler(MyDataException.class)
    public String handleError(MyDataException e) {

        return "redirect:/showError.html";
    }
}

