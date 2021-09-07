package com.zetcode.service;

import com.zetcode.model.City;
import com.zetcode.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findByNameEndingWith(String ending) {
        return cityRepository.findByNameEndingWith(ending);
    }

    @Override
    public List<City> findByPopulationLessThan(int population) {
        return cityRepository.findByPopulationLessThan(population);
    }
}