package com.zetcode.service;

import com.zetcode.model.Cities;
import com.zetcode.model.City;

public interface ICityService {

    Cities findAll();
    City findById(Long id);
}