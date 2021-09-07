package com.zetcode.repository;

import com.zetcode.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CityRepositoryTest {

	/*TestEntityManager allows to use EntityManager in tests. Spring Repository is an abstraction over EntityManager; 
	 * it shields developers from lower-level details of JPA and brings many convenient methods.
	 *  But Spring allows to use EntityManager when needed in application code and tests.
	 */
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepository repository;

    @Test
    public void testFindByName() {

        entityManager.persist(new City("Bratislava", 432000));
        entityManager.persist(new City("Budapest", 1759000));
        entityManager.persist(new City("Prague", 1280000));
        entityManager.persist(new City("Warsaw", 1748000));

        var cities = repository.findByName("Bratislava");
        assertEquals(1, cities.size());

        assertThat(cities).extracting(City::getName).containsOnly("Bratislava");
    }
}