package com.example.backend.mapper;

import com.example.backend.dto.request.DiaryEntryRequest;
import com.example.backend.dto.response.DiaryEntryResponse;
import com.example.backend.entities.LogEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiaryEntryMapper {

    DiaryEntryResponse entityToResponse(LogEntry diaryEntry);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "media", ignore = true)
    LogEntry requestToEntity(DiaryEntryRequest diaryEntryRequest);

}
