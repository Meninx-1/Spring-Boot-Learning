package com.zetcode.service;

import com.zetcode.model.City;
import com.zetcode.repository.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findByNameEndsWith(String name) {

        var cities = (List<City>) repository.wfindByNameEndsWith(name);
        return cities;
    }
}