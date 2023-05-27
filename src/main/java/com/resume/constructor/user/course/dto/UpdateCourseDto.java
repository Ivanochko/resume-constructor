package com.resume.constructor.user.course.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UpdateCourseDto extends CreateCourseDto {

    private Long id;

    public UpdateCourseDto(String title,
                           Integer yearOfCompletion,
                           String placeOfLearning,
                           Long id) {
        super(title, yearOfCompletion, placeOfLearning);
        this.id = id;
    }

}
