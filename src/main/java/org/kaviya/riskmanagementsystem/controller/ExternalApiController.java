package org.kaviya.riskmanagementsystem.controller;


import org.kaviya.riskmanagementsystem.service.ExternalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external-data")
public class ExternalApiController {

    private final ExternalApiService externalApiService;

    public ExternalApiController(
            ExternalApiService externalApiService) {

        this.externalApiService = externalApiService;
    }

    @GetMapping("/stockdata")
    public String getStockExternalData() {

        return externalApiService.getData();
    }
}