package org.kaviya.riskmanagementsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalApiService {

    private final RestClient restClient;
    private final String apiKey;

    public ExternalApiService(
            RestClient restClient,
            @Value("${external-api.alpha-vantage.api-key}") String apiKey) {
        this.restClient = restClient;
        this.apiKey = apiKey;
    }

    public String getData() {

        return restClient.get()
                .uri("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey={apiKey}", apiKey)
                .retrieve()
                .body(String.class);
    }
}