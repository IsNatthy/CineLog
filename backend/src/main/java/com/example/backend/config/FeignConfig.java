package com.example.backend.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    private final TmdbConfig tmdbConfig;

    public FeignConfig(TmdbConfig tmdbConfig) {
        this.tmdbConfig = tmdbConfig;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + tmdbConfig.getApiKey());
            requestTemplate.header("Content-Type", "application/json");
        };

    }
}
