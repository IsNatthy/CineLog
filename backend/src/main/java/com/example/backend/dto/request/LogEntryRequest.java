package com.example.backend.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LogEntryRequest {

    private Long userId;
    private Long movieId;
    private Double rating;
    private String body;
    private Boolean isRewatch;
    private LocalDate watchDate;

}
