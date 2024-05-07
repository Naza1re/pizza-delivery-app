package org.example.pizzaservice.exception;

public class PizzaNotFoundException extends RuntimeException {
    public PizzaNotFoundException(String s) {
        super(s);
    }
}
