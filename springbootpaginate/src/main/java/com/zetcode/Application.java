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
$ curl localhost:8080/countries/0/5
[{"id":1,"name":"China","population":1382050000},{"id":2,"name":"India","population":1313210000},
{"id":3,"name":"USA","population":324666000},{"id":4,"name":"Indonesia","population":260581000},
{"id":5,"name":"Brazil","population":207221000}]
We get the first page of 5 rows. The indexing starts from 0.

$ curl localhost:8080/countries/1/5
[{"id":6,"name":"Pakistan","population":196626000},{"id":7,"name":"Nigeria","population":186988000},
{"id":8,"name":"Bangladesh","population":162099000},{"id":9,"name":"Russia","population":146838000},
{"id":10,"name":"Japan","population":126830000}]
*/