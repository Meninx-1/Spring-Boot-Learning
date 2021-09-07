package com.zetcode;

import com.zetcode.config.MailProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private MailProperties mailProperties;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Hostname: {}", mailProperties.getHostname());
        logger.info("Port: {}", mailProperties.getPort());
        logger.info("From: {}", mailProperties.getFrom());
        logger.info("Recipients: {}", mailProperties.getRecipients());
    }
}