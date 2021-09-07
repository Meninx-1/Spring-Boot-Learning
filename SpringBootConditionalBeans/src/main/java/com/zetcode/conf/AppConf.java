package com.zetcode.conf;

import com.zetcode.bean.GenericMessage;
import com.zetcode.bean.WelcomeMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    @ConditionalOnProperty(name="welcomebean.enabled", havingValue="true")
    public WelcomeMessage welcomeBeanBean() {

        return new WelcomeMessage("Welcome!");
    }

    @Bean
    @ConditionalOnMissingBean(WelcomeMessage.class)
    public GenericMessage messageBean() {

        return new GenericMessage("Today is a beautiful day.");
    }
}
