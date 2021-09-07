package com.zetcode;

import com.zetcode.service.CountWords;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	// this is to get the file from the resources folder using getRresource() function
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CountWords countWords;

    @Override
    public void run(String... args) throws Exception {

        Resource res = resourceLoader.getResource("classpath:thermopylae.txt");

        Map<String, Integer> words =  countWords.getWordsCount(res);

        for (String key : words.keySet()) {

            System.out.println(key + ": " + words.get(key));
        }
    }
}