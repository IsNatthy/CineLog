package com.example.backend.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserMovieRequest {

    private Long userId;
    private Long movieId;
    private String state;
    private Double rating;
    private String comment;

    private LocalDate dateWatched;
}
