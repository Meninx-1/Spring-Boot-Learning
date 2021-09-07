package com.zetcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zetcode.service.IMessageService;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    IMessageService messageService;

    @RequestMapping(value = "/getMessage")
    public String getMessage() {

        String message = messageService.getMessage();

        return message;
    }

    // MessageService also contains the doLog() method decorated with @PostConstruct. 
    // It is called after the bean is initialized.
    @PostConstruct
    public void doLog() {
        logger.info("Info message in MyController");
    }
}