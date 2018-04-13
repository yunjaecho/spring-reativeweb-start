package com.yunae.reativeWeb.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RestSampleService {

    private RestTemplate restTemplate;


    public RestSampleService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    public String getName() {
        return restTemplate.getForObject("/message", String.class);
    }

}
