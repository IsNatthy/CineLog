package com.example.backend.mapper;

import com.example.backend.dto.request.UsersRequest;
import com.example.backend.dto.response.UsersResponse;
import com.example.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {

    UsersResponse entityToResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "diaryEntries", ignore = true)
    User requestToEntity(UsersRequest usersRequest);

    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "diaryEntries",  ignore = true)
    void updateUsersFromDTO(UsersRequest usersRequest, @MappingTarget User user);
}
