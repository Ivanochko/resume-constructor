package com.resume.constructor.user.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> getAllByUserIdOrderByYearOfCompletionDesc(Long userId);

}
