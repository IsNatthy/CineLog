package com.example.backend.dto.response;

import lombok.Data;

@Data
public class MediaResponse {

    private Long id;
    private Long tmbdId;
    private String title;
    private String posterPath;

}
