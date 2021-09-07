package com.zetcode.test;

import java.util.List;

import com.zetcode.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("http://localhost:${local.server.port}/${server.servlet.context-path}/cities")
    private String appPath;

    private City c1, c2, c3;

    @Before
    public void setUp() {

        this.c1 = new City(1L, "Bratislava", 432000);
        this.c2 = new City(2L, "Budapest", 1759000);
        this.c3 = new City(3L, "Prague", 1280000);
    }

    @Test
    public void allCitiesTest() {

        var paramType = new ParameterizedTypeReference<List<City>>() { };
        var cities = restTemplate.exchange(appPath, HttpMethod.GET, null, paramType);

        assertThat(cities.getBody()).hasSize(8);
        assertThat(cities.getBody()).contains(this.c1, this.c2, this.c3);
    }

    @Test
    public void oneCity() {

        var city = this.restTemplate.getForObject(appPath + "/1/", City.class);
        assertThat(city).extracting("name", "population").containsExactly("Bratislava",
                432000);
    }
}