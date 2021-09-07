package com.zetcode.service;

import com.zetcode.model.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICityService {

    Mono<City> insert(City city);
    Flux<City> saveAll(List<City> cities);
    Mono<City> findById(String id);
    Flux<City> findAll();
    Mono<Void> deleteAll();
}