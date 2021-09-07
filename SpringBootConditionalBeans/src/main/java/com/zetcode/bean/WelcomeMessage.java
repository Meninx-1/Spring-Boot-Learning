package com.zetcode.bean;

public class WelcomeMessage implements MessageBean {

    private String message;

    public WelcomeMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
