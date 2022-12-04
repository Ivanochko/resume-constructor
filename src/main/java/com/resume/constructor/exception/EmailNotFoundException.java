package com.resume.constructor.exception;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String email) {
        super("Failed to find user with email " + email);
    }

}
