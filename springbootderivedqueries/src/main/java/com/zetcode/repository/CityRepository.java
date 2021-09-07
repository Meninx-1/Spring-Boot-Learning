package com.zetcode.repository;

import com.zetcode.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Spring Data JPA can create queries from method names. 
 * This is a specific form of a convention over configuration. 
 * Spring Data JPA creates queries from specific keywords with combination of attributes;
 *  for instance: findByAgeLessThan, findByFirstnameEndingWith, or findByFirstnameEquals.
 *   The list of keywords is available in Spring Data JPA
 */

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findByNameEndingWith(String ending);
    List<City> findByPopulationLessThan(int population);
}