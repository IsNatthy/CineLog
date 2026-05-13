package com.example.backend.controller;

import com.example.backend.dto.request.UsersRequest;
import com.example.backend.dto.response.UsersResponse;
import com.example.backend.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UsersResponse>> findAllUsers() {
        return ResponseEntity.ok(usersService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UsersResponse> createUser(@RequestBody UsersRequest request) {
        return new ResponseEntity<>(usersService.createUser(request),  HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersResponse> updateUser(@PathVariable Long id, @RequestBody UsersRequest request) {
        return ResponseEntity.ok(usersService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsersResponse> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
