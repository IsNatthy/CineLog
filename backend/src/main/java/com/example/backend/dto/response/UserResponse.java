package com.example.backend.dto.response;

import lombok.Data;

@Data
public class UsersResponse {

    private Long id;
    private String name;
    private String surname;
    private String email;

}
