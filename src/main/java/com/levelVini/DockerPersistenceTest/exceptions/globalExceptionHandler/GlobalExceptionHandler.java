package com.levelVini.DockerPersistenceTest.exceptions.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> Exception(Exception ex) {
        ErrorResponse erro = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
