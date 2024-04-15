package com.example.restaurantservice.exception.handler;

import com.example.restaurantservice.exception.RestaurantAlreadyExistException;
import com.example.restaurantservice.exception.RestaurantNotFoundException;
import com.example.restaurantservice.exception.appError.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<AppError> handlerNotFoundException(RuntimeException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new AppError(message));
    }

    @ExceptionHandler(RestaurantAlreadyExistException.class)
    public ResponseEntity<AppError> handlerConflictException(RuntimeException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new AppError(message));
    }
}
