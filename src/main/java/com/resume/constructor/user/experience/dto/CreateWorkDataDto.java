package com.resume.constructor.user.experience.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CreateWorkDataDto {

    private String jobTitle;
    private String company;
    private String startDate;
    private String endDate;
    private String participation;
    private Boolean isCurrent;

}
