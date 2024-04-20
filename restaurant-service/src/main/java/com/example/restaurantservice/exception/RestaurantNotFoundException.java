package com.example.restaurantservice.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String s) {
        super(s);
    }
}
