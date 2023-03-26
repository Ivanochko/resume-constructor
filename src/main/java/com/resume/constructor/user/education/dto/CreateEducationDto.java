package com.resume.constructor.user.education.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CreateEducationDto {

    private String title;
    private String degree;
    private Integer yearOfGraduation;
    private String placeOfGraduation;

}
