package com.zetcode;

import com.zetcode.model.City;
import com.zetcode.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
 
@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private CityService cityService;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Creating cities");

        var cities = List.of(new City("Bratislava", 432000),
                new City("Budapest", 1759000),
                new City("Prague", 1280000),
                new City("Warsaw", 1748000));
        
// https://www.baeldung.com/reactor-core
        Mono<Void> one = cityService.deleteAll();

        Flux<City> two = cityService.saveAll(cities);
        Flux<City> three = cityService.findAll();
        three.subscribe(city -> logger.info("{}", city));

        
        Mono<Void> all = Mono.when(one, two, three);
        //Here, we're blocking the execution as long as the publisher doesn't emit the value. However,
        //it can take any amount of time to finish
        all.block();
    }
}