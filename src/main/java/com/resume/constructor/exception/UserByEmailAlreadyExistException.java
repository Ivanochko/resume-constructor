package com.resume.constructor.exception;

public class UserByEmailAlreadyExistException extends RuntimeException {

    public UserByEmailAlreadyExistException(String email) {
        super("User by email '" + email + "' already exist!");
    }

}
