package com.zetcode.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String home(@RequestParam(value="name") int name) {
    	
    	int a=name;

        return "Home page";
    }
    

//    @GetMapping("/custom/error")
//    public String getCustomError(@RequestHeader(name = "code") String errorCode) {
//
//     if ("400".equals(errorCode)) {
//      return "400";
//     } else if ("404".equals(errorCode)) {
//      return "404";
//     }
//
//     return "error";
//    }
//
//
//    public String getErrorPath() {
//     return "/error";
//    }

}