package com.zetcode.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*
 * @ConfigurationProperties allows to map the entire Properties and Yaml files into an object easily.
 *  It also allows to validate properties with JSR-303 bean validation. By default, 
 *  the annotation reads from the application.properties file.
 *  The source file can be changed with @PropertySource annotation.
 */
// you can put @Component instead of @Configuration
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String colour;
    private String lang;
    private String theme;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}