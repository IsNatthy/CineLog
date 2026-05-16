package com.example.backend.mapper;

import com.example.backend.dto.request.MovieRequest;
import com.example.backend.dto.response.MovieResponse;
import com.example.backend.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {

    MovieResponse entityToResponse(Movie movie);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstAddedAt", ignore = true)
    Movie requestToEntity(MovieRequest movieRequest);

}
