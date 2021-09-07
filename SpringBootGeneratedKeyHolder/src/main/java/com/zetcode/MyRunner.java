package com.zetcode;

import com.zetcode.model.MaritalStatus;
import com.zetcode.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private IUserService userService;

    @Override
    public void run(String... args) throws Exception {

        var u1 = userService.create("John Doe", MaritalStatus.SINGLE);
        logger.info("{} created", u1);

        var u2 = userService.create("Bill Dennis", MaritalStatus.MARRIED);
        logger.info("{} created", u2);

        var u3 = userService.create("Lucia Smith", MaritalStatus.SINGLE);
        logger.info("{} created", u3);

        var u4 = userService.create("Robert Brown", MaritalStatus.NOT_SPECIFIED);
        logger.info("{} created", u4);

        var users = userService.findAll();
        logger.info("{}", users);
    }
}