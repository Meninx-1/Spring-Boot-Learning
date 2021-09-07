package com.zetcode;

import com.zetcode.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ICityService cityService;

    @Override
    public void run(String... args) throws Exception {

        var city = cityService.findById(1L);
        System.out.println(city);

        var data = cityService.findAll();
        System.out.println(data);
    }
}