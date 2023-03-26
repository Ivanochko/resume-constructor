package com.resume.constructor.user.experience.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UpdateWorkDataDto extends CreateWorkDataDto {

    private Long id;

    public UpdateWorkDataDto(Long id,
                             String jobTitle,
                             String company,
                             String startDate,
                             String endDate,
                             String participation,
                             Boolean isCurrent) {
        super(jobTitle, company, startDate, endDate, participation, isCurrent);
        this.id = id;
    }
}
