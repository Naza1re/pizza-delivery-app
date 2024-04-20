package com.example.restaurantservice.exception;

public class RestaurantAlreadyExistException extends RuntimeException {
    public RestaurantAlreadyExistException(String s) {
        super(s);
    }
}
