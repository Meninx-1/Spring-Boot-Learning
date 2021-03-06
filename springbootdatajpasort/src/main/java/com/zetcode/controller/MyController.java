package com.zetcode.controller;

import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ICityService cityService;

    @GetMapping(value = "/cities")
    public List<City> getCitiesByPopulation() {

        return cityService.findAllOrderByPopulationAsc();
    }

    @GetMapping(value = "/cities2")
    public List<City> getCitiesByName() {

        return cityService.findAllOrderByNameAsc();
    }
}