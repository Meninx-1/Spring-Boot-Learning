package com.zetcode;

import com.zetcode.config.AppConfig;
import com.zetcode.service.MyRestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
/*
 * The @RestClientTest annotation is used to test Spring rest clients. 
 * It disables full auto-configuration and applies only configuration relevant to rest client tests.
 */
@RunWith(SpringRunner.class)
@RestClientTest(value={MyRestService.class, AppConfig.class})
public class ApplicationTests {

    @Autowired
    private MyRestService service;

    @Test
    public void usersNotEmpty() throws Exception {

        var users = this.service.getUsers();
        assertThat(users).isNotEmpty();
    }

    @Test
    public void hasSizeOneHundred() throws Exception {

        var users = this.service.getUsers();
        assertThat(users).hasSize(100);

        System.out.println(users);
    }
}