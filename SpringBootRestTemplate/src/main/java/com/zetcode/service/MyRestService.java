package com.zetcode.service;

import com.zetcode.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//MyRestService is the service class that generates the HTTP request. 
//It fetches all users from the JSON test server.
@Service
public class MyRestService {

    @Autowired
    private RestTemplate myRestTemplate;

    @Value("${myrest.url}")
    private String restUrl;

    public User[] getUsers() {

        var users = myRestTemplate.getForObject(restUrl, User[].class);

        return users;
    }
}