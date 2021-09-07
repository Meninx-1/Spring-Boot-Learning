package com.zetcode.repository;

import com.zetcode.model.City;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

@Configuration
public interface CityRepository extends ReactiveMongoRepository<City, String> {
}