package com.task.crudApplication.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return ErrorResponse.builder()
                .message(userNotFoundException.getMessage())
                .status(BAD_REQUEST)
                .build();
    }
}
