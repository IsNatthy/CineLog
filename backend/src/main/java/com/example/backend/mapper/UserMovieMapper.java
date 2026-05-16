package com.example.backend.mapper;

import com.example.backend.dto.request.UserMovieRequest;
import com.example.backend.dto.response.UserMovieResponse;
import com.example.backend.entities.UserMovie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMovieMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "movieId", source = "movie.id")
    UserMovieResponse userMovieToUserMovieResponse(UserMovie userMovie);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "addedAt", ignore = true)
    UserMovie requestToEntity(UserMovieRequest userMovieRequest);
}
