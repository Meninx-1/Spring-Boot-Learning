package com.zetcode.model;

import org.springframework.stereotype.Component;

@Component
public class Manager implements Person {

    @Override
    public String info() {
        return "Manager";
    }
}