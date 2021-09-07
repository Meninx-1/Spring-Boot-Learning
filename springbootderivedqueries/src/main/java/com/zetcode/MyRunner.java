package com.zetcode;

import com.zetcode.service.ICityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private ICityService cityService;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Finding cities having population less than one million");
        var res1 = cityService.findByPopulationLessThan(1000000);
        logger.info("{}", res1);

        logger.info("Finding cities by name ending with 'est'");
        var res2 = cityService.findByNameEndingWith("est");
        logger.info("{}", res2);
    }
}