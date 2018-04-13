package com.yunae.reativeWeb.controller;

import com.yunae.reativeWeb.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @GetMapping("/message")
    public String message() {
        return sampleService.message();
    }
}
