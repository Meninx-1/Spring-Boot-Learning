package com.zetcode.service;

import com.zetcode.model.City;

import java.util.List;

public interface ICityService {

    List<City> findByNameEndingWith(String ending);
    List<City> findByPopulationLessThan(int population);
}