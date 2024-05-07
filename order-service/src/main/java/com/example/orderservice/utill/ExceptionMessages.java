package com.example.orderservice.utill;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessages {
    public final static String ORDER_NOT_FOUND = "Order with id ' %s ' not found";
    public final static String CLIENT_SERVICE_NOT_AVAILABLE = "Client service is not available with message : ' %s '";
    public final static String PIZZA_SERVICE_NOT_AVAILABLE = "Pizza service is not available with message : ' %s '";
    public final static String DELIVERY_MAN_SERVICE_NOT_AVAILABLE = "DeliveryMan service is not available with message : ' %s '";
}
