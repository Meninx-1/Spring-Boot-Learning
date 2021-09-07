package com.zetcode.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
 * @ConfigurationProperties allows to map the entire Properties and Yaml files into an object easily.
 *  It also allows to validate properties with JSR-303 bean validation. By default, 
 *  the annotation reads from the application.properties file.
 *  The source file can be changed with @PropertySource annotation.
 */
@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties
@Validated
public class MailProperties {

    @NotNull
    private String hostname;

    @Min(1000)
    @Max(10000)
    private int port;

    @NotNull
    private String from;

    @NotNull
    private List<String> recipients;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
}