package com.zetcode.mapper;

import com.zetcode.model.MaritalStatus;
import com.zetcode.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new User(rs.getLong("id"), rs.getString("name"),
                MaritalStatus.values()[rs.getInt("marital_status")]);
    }
}