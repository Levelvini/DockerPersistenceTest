package com.levelVini.DockerPersistenceTest.exceptions.globalExceptionHandler;

import com.levelVini.DockerPersistenceTest.exceptions.EmptyListException;
import com.levelVini.DockerPersistenceTest.exceptions.ResourseNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> Exception(Exception ex) {
        ErrorResponse erro = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundedHandler(EntityNotFoundException ex){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> HTTPMessageNotReadableHandler(HttpMessageNotReadableException ex){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> HTTPRequestMethodNotSuported(HttpRequestMethodNotSupportedException ex){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ErrorResponse> EmptyListExceptionHandler(EmptyListException ex){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourseNotFoundExceptionHandler(ResourseNotFoundException ex){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
