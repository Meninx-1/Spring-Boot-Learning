package com.zetcode.controller;

import com.zetcode.model.Country;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    
	//ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result,
	//we can use it to fully configure the HTTP response.
    @RequestMapping(value = "/getCountry")
    public ResponseEntity<Country> getCountry() {
        
        var c = new Country();
        c.setName("France");
        c.setPopulation(66984000);
        
        var headers = new HttpHeaders();
        headers.add("Responded", "MyController");
        
        return ResponseEntity.accepted().headers(headers).body(c);
    }
    
    @RequestMapping(value = "/getCountry2")
    @ResponseBody
    public Country getCountry2() {
        
        var c = new Country();
        c.setName("France");
        c.setPopulation(66984000);
        
        return c;
    }    
}