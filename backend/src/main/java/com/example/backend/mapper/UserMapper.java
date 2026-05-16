package com.example.backend.mapper;

import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;
import com.example.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponse entityToResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "logEntries", ignore = true)
    User requestToEntity(UserRequest userRequest);

    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "logEntries",  ignore = true)
    void updateUsersFromDTO(UserRequest userRequest, @MappingTarget User user);
}
