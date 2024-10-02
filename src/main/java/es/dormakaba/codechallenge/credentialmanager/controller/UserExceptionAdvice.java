package es.dormakaba.codechallenge.credentialmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.dormakaba.codechallenge.credentialmanager.domain.UserAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.ValidationException;

@RestControllerAdvice
public class UserExceptionAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public String validationExceptionHandler(ValidationException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public String userAlreadyExistsExceptionHandler(UserAlreadyExistsException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e) {
        // TODO: log server-side error
        return "An unexpected error occurred on the server. Please try again later. If the problem persists, contact support.";
    }
}