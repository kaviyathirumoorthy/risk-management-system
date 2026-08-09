package org.kaviya.riskmanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/test")
    public String test() {
        return "Security not required!";
    }
    @GetMapping("/api/test-required")
    public String testRequired() {
        return "Security is working!";
    }
}
