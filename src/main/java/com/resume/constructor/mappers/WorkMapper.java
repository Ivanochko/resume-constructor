package com.resume.constructor.mappers;

import java.time.LocalDate;

import com.resume.constructor.user.experience.dto.CreateWorkDataDto;
import com.resume.constructor.user.experience.dto.UpdateWorkDataDto;
import com.resume.constructor.user.experience.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface WorkMapper {

    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "parseLocalDate")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "parseLocalDate")
    Work toWorkData(CreateWorkDataDto createWorkDataDto);

    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "parseLocalDate")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "parseLocalDate")
    Work toWorkData(UpdateWorkDataDto updateWorkDataDto);

    @Named("parseLocalDate")
    static LocalDate parseLocalDate(String date) {
        return date != null ? LocalDate.parse(date.substring(0, 10)) : LocalDate.now();
    }

}
