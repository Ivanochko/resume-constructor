package com.resume.constructor.api;

import java.util.List;

import com.resume.constructor.user.education.Education;
import com.resume.constructor.user.education.EducationService;
import com.resume.constructor.user.education.dto.CreateEducationDto;
import com.resume.constructor.user.education.dto.UpdateEducationDto;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get all educations by current authenticated user")
    public List<Education> getAllByCurrentUser() {
        return educationService.getAllByCurrentUser();
    }

    @PostMapping
    @Operation(summary = "Create new education")
    public Education createNew(@RequestBody CreateEducationDto createEducationDto) {
        return educationService.saveNew(createEducationDto);
    }

    @PutMapping
    @Operation(summary = "Update passed existing education")
    public Education update(@RequestBody UpdateEducationDto updateEducationDto) {
        return educationService.update(updateEducationDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete existing education by given id")
    public void delete(@PathVariable Long id) {
        educationService.delete(id);
    }

}