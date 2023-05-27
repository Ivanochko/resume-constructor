package com.resume.constructor.api;

import java.util.List;

import com.resume.constructor.user.course.Course;
import com.resume.constructor.user.course.CourseService;
import com.resume.constructor.user.course.dto.CreateCourseDto;
import com.resume.constructor.user.course.dto.UpdateCourseDto;
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
@RequestMapping("users/courses")
public class CoursesController {

    private final CourseService courseService;

    @GetMapping
    @Operation(summary = "Get all courses by current authenticated user")
    public List<Course> getAllByCurrentUser() {
        return courseService.getAllByCurrentUser();
    }

    @PostMapping
    @Operation(summary = "Create new course")
    public Course createNew(@RequestBody CreateCourseDto createCourseDto) {
        return courseService.saveNew(createCourseDto);
    }

    @PutMapping
    @Operation(summary = "Update passed existing course")
    public Course update(@RequestBody UpdateCourseDto updateCourseDto) {
        return courseService.update(updateCourseDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete existing course by given id")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

}