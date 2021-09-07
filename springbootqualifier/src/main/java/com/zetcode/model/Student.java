package com.zetcode.model;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person {

    @Override
    public String info() {

        return "Student";
    }
}