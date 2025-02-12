package com.resume.constructor.user.dto;

import java.util.List;

import com.resume.constructor.user.course.Course;
import com.resume.constructor.user.education.Education;
import com.resume.constructor.user.experience.Work;
import com.resume.constructor.user.personal.dto.UserAllPersonalFieldsDto;
import com.resume.constructor.user.skills.Skill;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UserAllDataDto extends UserAllPersonalFieldsDto {

    private List<Work> works;
    private List<Education> educations;
    private List<Course> courses;
    private List<Skill> skills;

}
