package com.zetcode.controller;

import com.zetcode.exception.OrderNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(value = "/orders/{id}")
    @ResponseBody
    public String getOrder(@PathVariable("id") long id) {

        if (id < 0 || id > 500) {

            var message = String.format("Order %d not found", id);
            throw new OrderNotFoundException(message);
        }

        var message = String.format("Returning order %d", id);

        return message;
    }
}