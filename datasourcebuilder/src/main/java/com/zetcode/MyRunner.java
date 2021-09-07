package com.zetcode;

import com.zetcode.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {

        var sql = "SELECT * FROM cars";

        var cars = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Car.class));

        for (Car car: cars) {

            System.out.println(car);
        }
    }
}