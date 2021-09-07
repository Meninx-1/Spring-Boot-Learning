package com.zetcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
 * The error.ftlh is a generic error page. It is Freemarker template file which shows 
 * status, error, and the reason message. These values were set with @ResponseStatus earlier.
 *  It is located in the src/main/resources/templates directory.
 *  When the reason is added to @ResponseStatus we use it instead of the message
 *  try remove it and see
 *   On invoking the marked handler method or when a specified exception is thrown, 
 *   the HTTP status will be set to the one defined using @ResponseStatus annotation.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "No such order")
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {

        super(message);
    }
}