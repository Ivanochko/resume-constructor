package com.resume.constructor.mappers;

import com.resume.constructor.user.education.Education;
import com.resume.constructor.user.education.dto.CreateEducationDto;
import com.resume.constructor.user.education.dto.UpdateEducationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    Education toEducation(CreateEducationDto createEducationDto);

    Education toEducation(UpdateEducationDto updateEducationDto);

}
