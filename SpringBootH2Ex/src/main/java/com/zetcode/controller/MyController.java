package com.zetcode.controller;

import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ICityService cityService;

    @RequestMapping("/cities")
    public List<City> findCities() {

        return cityService.findAll();
    }

    @RequestMapping("/cities/{cityId}")
    public City findCity(@PathVariable Long cityId) {

        return cityService.findById(cityId);
    }
/*
 * You can add extra (@ExceptionHandler) methods to any controller to specifically handle exceptions 
 * thrown by request handling (@RequestMapping) methods in the same controller. Such methods can:

1-Handle exceptions without the @ResponseStatus annotation (typically predefined exceptions that you didn’t write)
2-Redirect the user to a dedicated error view
3-Build a totally custom error response
 */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> noCityFound(EmptyResultDataAccessException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No City found");
    }
}