package com.example.backend.services.servicesImpl;

import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;
import com.example.backend.entities.User;
import com.example.backend.mapper.UserMapper;
import com.example.backend.repositories.UserRepository;
import com.example.backend.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

        return userMapper.entityToResponse(user);
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User userEntity = userMapper.requestToEntity(userRequest);

        User savedUser = userRepository.save(userEntity);

        return userMapper.entityToResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

        userMapper.updateUsersFromDTO(userRequest, existingUser);

        return userMapper.entityToResponse(userRepository.save(existingUser));
    }

    @Override
    public UserResponse deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

        userRepository.delete(user);
        return  userMapper.entityToResponse(user);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
