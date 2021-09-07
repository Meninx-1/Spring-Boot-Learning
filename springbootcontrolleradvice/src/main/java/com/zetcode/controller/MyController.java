package com.zetcode.controller;

import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ICityService cityService;

    @GetMapping(value = "/cities/{id}")
    public City getCity(@PathVariable Long id) {

        return cityService.findById(id);
    }

    /*
     * The @Valid annotation will tell spring to go and validate the data passed into the controller
     *  by checking to see that the integer population is between min=10, max=100_000_000 inclusive because
     *  of those @Range annotations.
     */
    //@RequestBody : Annotation indicating a method parameter should be bound to the body of the HTTP request
    @PostMapping(value = "/cities", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public City createCity(@RequestBody @Valid City city) {

        return cityService.save(city);
    }

    @GetMapping(value = "/cities")
    public List<City> findAll() {

        return cityService.findAll();
    }
}