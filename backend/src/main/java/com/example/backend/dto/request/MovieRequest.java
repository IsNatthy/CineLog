package com.example.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieRequest {

    @JsonProperty("id")
    private Long tmdbId;

    private String title;

    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("poster_path")
    private String posterPath;

    private String overview;
    private Integer year;

}
