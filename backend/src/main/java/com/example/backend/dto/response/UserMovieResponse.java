package com.example.backend.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserMovieResponse {

    private Long userId;
    private Long movieId;
    private Long id;
    private String state;
    private Double rating;
    private String comment;

    private LocalDate dateWatched;
    private LocalDate addedAt;
}
