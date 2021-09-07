package com.zetcode.repository;

import com.zetcode.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
/*
 * @DataJpaTest
@DataJpaTest is used to test JPA repositories. It is used in combination with @RunWith(SpringRunner.class).
 The annotation disables full auto-configuration and applies only configuration relevant to JPA tests. 
 By default, tests annotated with @DataJpaTest use an embedded in-memory database.

In our tests, we can inject a DataSource, @JdbcTemplate, @EntityManager or any Spring Data repository from our application.

The application context containing all these components, including the in-memory database, 
is shared between all test methods within all test classes annotated with @DataJpaTest. 
Therefore, each test method runs in its own transaction, which is rolled back after the method has executed. 
This way the tests stay independent from each other.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CityRepositoryTest {

    @Autowired
    private CityRepository repository;

    @Test
    public void should_find_all_customers() {

        Iterable<City> cities = repository.findAll();

        int nOfCities = 12;
        assertThat(cities).hasSize(nOfCities);
    }

    @Test
    public void should_find_with_name_ending_population_less_than() {

        var cities = repository.findByNameEndingWithAndPopulationLessThan("est", 150000);

        assertThat(cities).isNotEmpty();
    }

}