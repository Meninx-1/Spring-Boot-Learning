package com.zetcode.controller;

import com.zetcode.model.Cities;
import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private ICityService cityService;

    @GetMapping(value="/cities", produces=MediaType.APPLICATION_XML_VALUE)
    public Cities findCities() {

        return cityService.findAll();
    }

    @GetMapping(value="/cities/{cityId}", produces=MediaType.APPLICATION_XML_VALUE)
    public City findCity(@PathVariable Long cityId) {

        return cityService.findById(cityId);
    }
}