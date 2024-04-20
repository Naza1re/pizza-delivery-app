package com.example.orderservice.exception.handler;

import com.example.orderservice.exception.FeignClientException;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.exception.error.AppError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler({OrderNotFoundException.class})
    public ResponseEntity<AppError> handlerNotFoundException(RuntimeException ex) {
        String errorMessage = ex.getMessage();
        log.error("Error from NotFoundExceptionHandler with message : {} was called", errorMessage);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new AppError(errorMessage));
    }

    @ExceptionHandler(FeignClientException.class)
    public ResponseEntity<AppError> handleFeignClientException(RuntimeException ex) {
        String errorMessage = ex.getMessage();
        log.error("Error from FeignClientExceptionHandler with message : {} was called", errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new AppError(errorMessage));
    }

}
