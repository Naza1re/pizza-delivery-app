package com.example.orderservice.utill;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessages {
    public final static String ORDER_NOT_FOUND = "Order with id ' %s ' not found";
    public static final String PIZZA_NOT_FOUND = "Pizza with id ' %s ' not found";
}
