package com.zetcode.exception;

public class MyDataException extends RuntimeException {

    public MyDataException(String message) {
        super(message);
    }
}