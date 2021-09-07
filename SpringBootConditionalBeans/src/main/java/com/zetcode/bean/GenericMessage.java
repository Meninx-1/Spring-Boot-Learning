package com.zetcode.bean;

public class GenericMessage implements MessageBean {

    private String message;

    public GenericMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}