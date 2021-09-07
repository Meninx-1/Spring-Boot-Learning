package com.zetcode.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}

/*
With the @ConfigurationProperties annotation, we have externalized the configuration into the YAML file.

In Spring framework, the @Primary annotation is used to give higher preference to a bean, 
when there are multiple beans of same type. The @Primary annotation may be used on any class directly 
or indirectly annotated with @Component or on methods annotated with @Bean

*/