package com.ozgur.PortPriceTracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello, User!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello, Admin!";
    }
}