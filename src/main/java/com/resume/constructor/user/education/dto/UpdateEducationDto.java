package com.resume.constructor.user.education.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UpdateEducationDto extends CreateEducationDto {

    private Long id;

    public UpdateEducationDto(String title,
                              String degree,
                              Integer yearOfGraduation,
                              String placeOfGraduation,
                              Long id) {
        super(title, degree, yearOfGraduation, placeOfGraduation);
        this.id = id;
    }
}
