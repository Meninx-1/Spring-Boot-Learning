package com.zetcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * In the MvcConfig class we configure a view and a controller for the home page. 
 * Since we have FreeMarker in the Maven POM file, Spring Boot automatically configures
 *  FreeMarker as the template engine. So the index view is mapped to the index.ftlh template file,
 *   which is located in the src/main/resources/templates directory.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}