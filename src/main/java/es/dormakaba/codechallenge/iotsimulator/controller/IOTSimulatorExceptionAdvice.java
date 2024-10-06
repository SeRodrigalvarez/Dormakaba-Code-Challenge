package es.dormakaba.codechallenge.iotsimulator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorAlreadyExistsException;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@RestControllerAdvice
public class IOTSimulatorExceptionAdvice {

    @ExceptionHandler(DoorAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentialAlreadyAddedExceptionHandler(DoorAlreadyExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(DoorNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentialAlreadyAddedExceptionHandler(DoorNotExistException e) {
        return e.getMessage();
    }
}
