package com.example.orderservice.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String s) {
        super(s);
    }
}
