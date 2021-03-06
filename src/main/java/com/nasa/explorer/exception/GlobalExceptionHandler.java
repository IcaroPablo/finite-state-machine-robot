package com.nasa.explorer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class, InvalidInstructionException.class})
    public ResponseEntity<String> badRequestHandler(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
    }

}