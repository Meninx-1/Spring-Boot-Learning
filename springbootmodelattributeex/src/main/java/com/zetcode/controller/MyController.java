package com.zetcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.zetcode.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MyController {

    @Autowired
    private IMessageService messageService;

    @GetMapping("/pageOne")
    public String getPageOne() {

        return "pageOne";
    }

    @GetMapping("/pageTwo")
    public String getPageTwo() {

        return "pageTwo";
    }

    /*
     * A method annotated with @ModelAttribute is executed before @RequestMapping method
     *  and their specializations such as @GetMapping. The message generated from the messageService 
     *  is stored in the motd model attribute and will be available to both Thymeleaf views.
     */
    
    /*
     * @ModelAttribute binds a method parameter or method return value to a named model attribute,
     *  which is exposed to web views. Methods annotated with @ModelAttribute are invoked before
     *   all the controller methods with @RequestMapping.
     */
    @ModelAttribute("motd")
    public String message() {

        return messageService.getMessage();
    }
}