package com.example.orderservice.exception.handler;

import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.exception.PizzaNotFoundException;
import com.example.orderservice.exception.error.AppError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler({PizzaNotFoundException.class, OrderNotFoundException.class})
    public ResponseEntity<AppError> handlerNotFoundException(RuntimeException ex) {
        String errorMessage = ex.getMessage();
        log.error("Error with message : "+ errorMessage+" was called");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new AppError(errorMessage));
    }
}
