package com.zetcode.service;

import com.zetcode.model.MaritalStatus;
import com.zetcode.model.User;
import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
    User create(String name, MaritalStatus status);
}