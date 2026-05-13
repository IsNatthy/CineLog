package com.example.backend.mapper;

import com.example.backend.dto.request.UsersRequest;
import com.example.backend.dto.response.UsersResponse;
import com.example.backend.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {

    UsersResponse entityToResponse(Users users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "diaryEntries", ignore = true)
    Users requestToEntity(UsersRequest usersRequest);

    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "diaryEntries",  ignore = true)
    void updateUsersFromDTO(UsersRequest usersRequest, @MappingTarget Users users);
}
