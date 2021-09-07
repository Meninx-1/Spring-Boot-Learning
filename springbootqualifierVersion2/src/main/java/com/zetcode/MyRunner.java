package com.zetcode;

import com.zetcode.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    @Qualifier("student")
    private Person p1;

    @Autowired
    @Qualifier("manager")
    private Person p2;

    @Override
    public void run(String... args) throws Exception {

        logger.info("{}", p1.info());
        logger.info("{}", p2.info());
    }
}