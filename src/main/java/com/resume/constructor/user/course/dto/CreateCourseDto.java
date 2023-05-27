package com.resume.constructor.user.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CreateCourseDto {

    private String title;
    private Integer yearOfCompletion;
    private String placeOfLearning;

}
