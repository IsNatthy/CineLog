package com.example.backend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class TmdbConfig {

    @Value("${tmbd.base.url}")
    private String baseUrl;
    @Value("${tmdb.api.key}")
    private String apiKey;
    @Value("${tmdb.api.token}")
    private String apiToken;
}
