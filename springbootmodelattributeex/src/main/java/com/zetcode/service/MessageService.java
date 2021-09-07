package com.zetcode.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {

    @Value("${messages.motd}")
    private String motd="Hello";

    @Override
    public String getMessage() {

        return motd;
    }
}