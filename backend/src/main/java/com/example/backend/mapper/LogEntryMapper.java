package com.example.backend.mapper;

import com.example.backend.dto.request.LogEntryRequest;
import com.example.backend.dto.response.LogEntryResponse;
import com.example.backend.entities.LogEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LogEntryMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "movieId", source = "movie.id")
    LogEntryResponse entityToResponse(LogEntry logEntry);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LogEntry requestToEntity(LogEntryRequest logEntryRequest);

}
