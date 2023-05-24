package com.resume.constructor.api;

import com.resume.constructor.exception.EmailNotFoundException;
import com.resume.constructor.exception.UserByEmailAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = EmailNotFoundException.class)
    public ResponseEntity<Object> emailNotFoundException(EmailNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserByEmailAlreadyExistException.class)
    public ResponseEntity<Object> userByEmailAlreadyExistException(UserByEmailAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler({ AuthenticationException.class })
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ResponseBody
    @ExceptionHandler({ HttpMessageNotReadableException.class })
    public ResponseEntity<Object> handleAuthenticationException(HttpMessageNotReadableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
