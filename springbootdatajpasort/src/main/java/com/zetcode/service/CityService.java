package com.zetcode.service;

import com.zetcode.model.City;
import com.zetcode.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAllOrderByPopulationAsc() {
        return repository.findAllOrderByPopulationAsc();
    }

    @Override
    public List<City> findAllOrderByNameAsc() {

        var sort = new Sort(Sort.Direction.ASC, "name");
        return repository.findAllOrderByNameAsc(sort);
    }
}