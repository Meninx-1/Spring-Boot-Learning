package com.zetcode.repository;

import com.zetcode.model.City;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	//The @Query annotation contains the custom JPQL querty
    @Query("select c from City c where c.name like %?1")
    List<City> wfindByNameEndsWith(String chars);
}