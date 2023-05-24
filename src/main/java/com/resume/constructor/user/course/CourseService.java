package com.resume.constructor.user.course;

import java.util.List;

import com.resume.constructor.exception.CourseNotExistException;
import com.resume.constructor.mappers.CourseMapper;
import com.resume.constructor.security.AuthService;
import com.resume.constructor.user.course.dto.CreateCourseDto;
import com.resume.constructor.user.course.dto.UpdateCourseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {

    private final AuthService authService;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<Course> getAllByCurrentUser() {
        Long userId = authService.getCurrentUserId();
        return courseRepository.getAllByUserIdOrderByYearOfCompletionDesc(userId);
    }

    public Course saveNew(CreateCourseDto createCourseDto) {
        Course course = courseMapper.toCourse(createCourseDto);
        Long userId = authService.getCurrentUserId();
        course.setUserId(userId);
        return courseRepository.save(course);
    }

    public Course update(UpdateCourseDto updateCourseDto) {
        boolean existsById = courseRepository.existsById(updateCourseDto.getId());
        if (!existsById) {
            throw new CourseNotExistException(updateCourseDto.getId());
        }
        Course course = courseMapper.toCourse(updateCourseDto);
        Long userId = authService.getCurrentUserId();
        course.setUserId(userId);
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

}
