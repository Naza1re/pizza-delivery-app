package org.example.clientservice.exception.handler;

import org.example.clientservice.exception.ClientAlreadyExistException;
import org.example.clientservice.exception.ClientNotFoundException;
import org.example.clientservice.exception.apperror.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<AppError> handleNotFoundException(RuntimeException ex) {
        String msg = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new AppError(msg));
    }

    @ExceptionHandler(ClientAlreadyExistException.class)
    public ResponseEntity<AppError> handleConflictException(RuntimeException ex) {
        String msg = ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new AppError(msg));
    }
}
