package com.example.backend.mapper;

import com.example.backend.dto.request.DiaryEntryRequest;
import com.example.backend.dto.response.DiaryEntryResponse;
import com.example.backend.entities.DiaryEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiaryEntryMapper {

    DiaryEntryResponse entityToResponse(DiaryEntry diaryEntry);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "media", ignore = true)
    DiaryEntry requestToEntity(DiaryEntryRequest diaryEntryRequest);

}
