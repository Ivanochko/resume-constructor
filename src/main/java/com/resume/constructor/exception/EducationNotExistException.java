package com.resume.constructor.exception;

public class EducationNotExistException extends RuntimeException {

    public EducationNotExistException(Long id) {
        super("Education with id '" + id + "' does not exist");
    }

}
