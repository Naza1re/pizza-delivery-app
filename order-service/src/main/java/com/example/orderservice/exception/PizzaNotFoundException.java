package com.example.orderservice.exception;

public class PizzaNotFoundException extends RuntimeException {
    public PizzaNotFoundException(String s) {
        super(s);
    }
}
