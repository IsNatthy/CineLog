package com.example.backend.services.servicesImpl;

import com.example.backend.dto.request.UsersRequest;
import com.example.backend.dto.response.UsersResponse;
import com.example.backend.entities.User;
import com.example.backend.mapper.UsersMapper;
import com.example.backend.repositories.UsersRepository;
import com.example.backend.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;
    private final UsersMapper usersMapper;

    public UsersServiceImpl(UsersRepository userRepository, UsersMapper usersMapper) {
        this.userRepository = userRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public UsersResponse findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

        return usersMapper.entityToResponse(user);
    }

    @Override
    public UsersResponse createUser(UsersRequest usersRequest) {
        User userEntity = usersMapper.requestToEntity(usersRequest);

        User savedUser = userRepository.save(userEntity);

        return usersMapper.entityToResponse(savedUser);
    }

    @Override
    public UsersResponse updateUser(Long id, UsersRequest usersRequest) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

        usersMapper.updateUsersFromDTO(usersRequest, existingUser);

        return usersMapper.entityToResponse(userRepository.save(existingUser));
    }

    @Override
    public UsersResponse deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));

        userRepository.delete(user);
        return  usersMapper.entityToResponse(user);
    }

    @Override
    public List<UsersResponse> findAllUsers() {
        return userRepository.findAll().stream()
                .map(usersMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
