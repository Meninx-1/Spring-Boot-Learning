package com.zetcode.service;

import com.zetcode.scheduling.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/*
 * The doHeadRequest() method issues a HEAD request to the webcode.me website 
 * and retrieves the date header from its response.
 */
@Service
public class HeadRequestService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private HttpHeaders headers;

    public String doHeadRequest() {

        HttpClient client = HttpClient.newHttpClient();

        try {
            var request = HttpRequest.newBuilder(URI.create("http://webcode.me"))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<Void> response = client.send(request,
                    HttpResponse.BodyHandlers.discarding());

            headers = response.headers();

        } catch (IOException | InterruptedException e) {

            log.error("Failed to send HEAD request");
        }

        var opt = headers.firstValue("date");
        return opt.orElse("");
    }
}