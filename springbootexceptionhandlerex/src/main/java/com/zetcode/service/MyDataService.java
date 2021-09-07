package com.zetcode.service;

import com.zetcode.exception.MyDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class MyDataService implements IDataService {

    @Override
    public List<String> findAll() {

        var r = new Random();

        if (r.nextBoolean()) {

            throw new MyDataException("Failed to retrieve data");
        }

        var data = new ArrayList<String>();

        data.add("yellow moon");
        data.add("brisk pace");
        data.add("empty bottle");
        data.add("beautiful weather");

        return data;
    }
}