package com.zetcode.service;

import com.zetcode.mapper.UserMapper;
import com.zetcode.model.MaritalStatus;
import com.zetcode.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements IUserService {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<User> findAll() {

        String sql = "SELECT * FROM users";

        return jtm.query(sql, new UserMapper());
    }

    @Override
    public User findById(Long id) {

        String sql = "SELECT * FROM users WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new UserMapper());
    }

    @Override
    public User create(String name, MaritalStatus status) {

        String sql = "INSERT INTO users(name, marital_status) VALUES (?, ?)";

        //We declare the two SqlParameters for the PreparedStatementCreatorFactory
        var decParams = List.of(new SqlParameter(Types.VARCHAR, "name"),
                new SqlParameter(Types.INTEGER, "marital_status"));

        //PreparedStatementCreatorFactory is a helper class that creates multiple PreparedStatementCreator objects
        //with different parameters based on an SQL statement and a single set of parameter declarations.
        var pscf = new PreparedStatementCreatorFactory(sql, decParams) {
            {
                setReturnGeneratedKeys(true);
                setGeneratedKeysColumnNames("id");
            }
        };

        var psc = pscf.newPreparedStatementCreator(List.of(name, status.ordinal()));

        //A GeneratedKeyHolder is created and passed with the PreparedStatementCreator 
        //to the JdbcTemplate's update method
        var keyHolder = new GeneratedKeyHolder();
        jtm.update(psc, keyHolder);

        var uid = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(uid);
    }
}