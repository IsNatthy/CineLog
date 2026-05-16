package com.example.backend.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LogEntryResponse {

    private Long id;
    private Long userId;
    private Long movieId;
    private Double rating;
    private String body;
    private Boolean isRewatch;
    private LocalDate watchDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
