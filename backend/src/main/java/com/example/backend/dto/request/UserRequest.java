package com.example.backend.dto.request;

import lombok.Data;

@Data
public class UsersRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthday;

    private String createdAt;
    private String updatedAt;
}
