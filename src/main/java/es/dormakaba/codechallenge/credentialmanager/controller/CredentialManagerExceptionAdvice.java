package es.dormakaba.codechallenge.credentialmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyAddedToUserException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserAlreadyAddedToCredentialException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.ValidationException;

@RestControllerAdvice
public class CredentialManagerExceptionAdvice {

    @ExceptionHandler(CredentialAlreadyAddedToUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentialAlreadyAddedExceptionHandler(CredentialAlreadyAddedToUserException e) {
        return e.getMessage();
    }

    @ExceptionHandler(CredentialAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentialAlreadyExistsExceptionHandler(CredentialAlreadyExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(CredentialNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentialNotExistExceptionHandler(CredentialNotExistException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserAlreadyAddedToCredentialException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userAlreadyAddedToCredentialExceptionHandler(UserAlreadyAddedToCredentialException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userAlreadyExistsExceptionHandler(UserAlreadyExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userNotExistExceptionHandler(UserNotExistException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String validationExceptionHandler(ValidationException e) {
        return e.getMessage();
    }
}