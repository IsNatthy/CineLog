package com.example.backend.services;

import com.example.backend.dto.request.UsersRequest;
import com.example.backend.dto.response.UsersResponse;

import java.util.List;

public interface UsersService {

    UsersResponse createUser(UsersRequest usersRequest);

    List<UsersResponse> findAllUsers();

    UsersResponse findUserById(Long id);

    UsersResponse updateUser(Long id, UsersRequest usersRequest);

    UsersResponse deleteUser(Long id);

}
