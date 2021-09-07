package com.zetcode.mapper;

import com.zetcode.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new City(rs.getLong("id"), rs.getString("name"), rs.getInt("population"));
    }
}
/*
The CityMapper maps a row of a result set to the City record.

Note: Since Java records are immutable and do not follow the Java Beans specification, 
we cannot use the BeanPropertyRowMapper; we have to create our own mapper

*/