package com.resume.constructor.mappers;

import com.resume.constructor.user.course.Course;
import com.resume.constructor.user.course.dto.CreateCourseDto;
import com.resume.constructor.user.course.dto.UpdateCourseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toCourse(CreateCourseDto createCourseDto);

    Course toCourse(UpdateCourseDto updateCourseDto);

}
