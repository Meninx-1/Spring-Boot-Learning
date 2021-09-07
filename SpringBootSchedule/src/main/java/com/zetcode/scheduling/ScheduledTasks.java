package com.zetcode.scheduling;

import com.zetcode.service.HeadRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private HeadRequestService headRequestService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    //Every 15s, the doHeadRequest() of the HeadRequestService is called.
    @Scheduled(fixedRate = 15000)
    public void getHeadValue() {
        log.info("Value: {}", headRequestService.doHeadRequest());
    }
}