package com.resume.constructor.exception;

public class CourseNotExistException extends RuntimeException {

    public CourseNotExistException(Long id) {
        super("Course with id '" + id + "' does not exist");
    }

}
