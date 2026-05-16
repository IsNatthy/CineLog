package com.example.backend.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieResponse {

    private Long id;
    private Long tmbdId;
    private String title;
    private String posterPath;
    private String overview;
    private LocalDateTime firstAddedAt;

}
