package com.zetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
GeneratedKeyHolder
GeneratedKeyHolder is a standard implementation of the KeyHolder interface,
 which is used for holding auto-generated keys. The auto-generated keys are 
 potentially returned by JDBC insert statements.
*/