package com.example.backend.services;

import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> findAllUsers();

    UserResponse findUserById(Long id);

    UserResponse updateUser(Long id, UserRequest userRequest);

    UserResponse deleteUser(Long id);

}
