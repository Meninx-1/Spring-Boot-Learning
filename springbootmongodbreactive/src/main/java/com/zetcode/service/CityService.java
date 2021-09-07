package com.zetcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zetcode.model.City;
import com.zetcode.repository.CityRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityService implements ICityService {
	
	@Autowired
	private CityRepository cityRepository;

	public Mono<Void> deleteAll() {

		return cityRepository.deleteAll();
	}

	public Flux<City> saveAll(List<City> cities) {

		return cityRepository.saveAll(cities);
	}

	public Flux<City> findAll() {

		return cityRepository.findAll();
	}

	@Override
	public Mono<City> insert(City city) {

		return cityRepository.insert(city);
	}

	@Override
	public Mono<City> findById(String id) {
		
		return cityRepository.findById(id);
	}

}
