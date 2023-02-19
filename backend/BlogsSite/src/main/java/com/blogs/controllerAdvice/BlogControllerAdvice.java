package com.blogs.controllerAdvice;

import com.blogs.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> validationException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }
}
