package com.zetcode.controller;

import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
 * In order to write data to the response body, we use the @RestController or the @Controller/@ResponseBody combination.
 */
@RestController
public class MyController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/cities")
    public List<City> getCities() {

        return cityService.getCities();
    }
}