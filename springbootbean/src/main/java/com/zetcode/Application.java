package com.zetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private AppName appName;

    @Bean
    public AppName getAppName(@Value("${app.name}") String appName) {

        return () -> appName;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Application name: {}", appName.getName());
        
        // we can call the bean without the need of the @Autowired
        AppName appNameBean = (AppName) applicationContext.getBean("getAppName");
        logger.info("Application name: {}", appNameBean.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}