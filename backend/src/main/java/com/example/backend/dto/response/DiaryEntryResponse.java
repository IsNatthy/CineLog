package com.example.backend.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DiaryEntryResponse {

    private Long id;
    private Double rating;
    private String review;
    private LocalDate watchDate;
    private MediaResponse media;

}
