package com.example.backend.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DiaryEntryRequest {

    private Long tmdbId; //pelicula a guardar
    private Double rating;
    private String review;
    private LocalDate watchDate;

}
