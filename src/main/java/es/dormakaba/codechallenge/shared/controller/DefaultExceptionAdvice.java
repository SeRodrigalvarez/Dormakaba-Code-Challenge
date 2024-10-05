package es.dormakaba.codechallenge.shared.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class DefaultExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String defaultExceptionHandler(Exception e) {
        logger.error("Default Exception Handler catched: ", e);
        return "An unexpected error occurred on the server. Please try again later. If the problem persists, contact support.";
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String httpMessageNotReadableException(HttpMessageNotReadableException e) {
        String errorMessage = e.getMessage();
        int endIndex = errorMessage.length();
        int indexOfColon = errorMessage.indexOf(':');
        if (indexOfColon != -1) {
            endIndex = indexOfColon;
        }
        return errorMessage.substring(0, endIndex);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String httpMessageNotReadableException(NoResourceFoundException e) {
        return  e.getMessage();
    }
}