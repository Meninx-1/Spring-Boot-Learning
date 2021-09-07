package com.zetcode.service;

import com.zetcode.bean.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<City> findAll() {

        String sql = "SELECT * FROM CITIES";

        //BeanPropertyRowMapper converts a row into a new instance of the specified mapped target class.
        List<City> cities = jtm.query(sql, new BeanPropertyRowMapper(City.class));

        return cities;
    }

    @Override
    public City findById(Long id) {

    	//This is SQL to select a specific city identified by id from the CITIES table.
        String sql = "SELECT * FROM CITIES WHERE ID=?";

        //To get one row from the CITIES table, we use the queryForObject() method.
        City city = (City) jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper(City.class));

        return city;
    }
}