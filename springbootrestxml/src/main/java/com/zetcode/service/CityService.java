package com.zetcode.service;

import com.zetcode.model.Cities;
import com.zetcode.model.City;
import com.zetcode.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public Cities findAll() {

        var cities = (List<City>) repository.findAll();
        var mycities = new Cities();
        mycities.setCities(cities);

        return mycities;
    }

    @Override
    public City findById(Long id) {

        return repository.findById(id).orElse(new City());
    }
}