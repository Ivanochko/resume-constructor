package com.resume.constructor.exception;

public class WorkDataNotExistException extends RuntimeException {

    public WorkDataNotExistException(Long id) {
        super("Work data with id '" + id + "' does not exist");
    }

}
