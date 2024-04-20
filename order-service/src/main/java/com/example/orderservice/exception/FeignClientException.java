package com.example.orderservice.exception;

public class FeignClientException extends RuntimeException {
    public FeignClientException(String message) {
        super(message);
    }
}
