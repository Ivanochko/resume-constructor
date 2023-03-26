package com.resume.constructor.api;

import java.util.List;

import com.resume.constructor.user.education.Education;
import com.resume.constructor.user.education.EducationService;
import com.resume.constructor.user.education.dto.CreateEducationDto;
import com.resume.constructor.user.education.dto.UpdateEducationDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users/educations")
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public List<Education> getAllByCurrentUser() {
        return educationService.getAllByCurrentUser();
    }

    @PostMapping
    public Education createNew(@RequestBody CreateEducationDto createEducationDto) {
        return educationService.saveNew(createEducationDto);
    }

    @PutMapping
    public Education update(@RequestBody UpdateEducationDto updateEducationDto) {
        return educationService.update(updateEducationDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        educationService.delete(id);
    }

}