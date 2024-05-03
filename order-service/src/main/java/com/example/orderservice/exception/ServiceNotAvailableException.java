package com.example.orderservice.exception;

public class ServiceNotAvailableException extends RuntimeException {
    public ServiceNotAvailableException(String s) {
        super(s);

    }
}
