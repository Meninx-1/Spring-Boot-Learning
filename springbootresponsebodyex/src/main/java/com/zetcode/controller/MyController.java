package com.zetcode.controller;

import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    ICityService cityService;

    @RequestMapping(path = "/")
    public String index() {

        return "index";
    }

    @RequestMapping(path = "/GetCities", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<City> findCities() {

        var cities = (List<City>) cityService.findAll();

        return cities;
    }
}