package com.example.orderservice.service;

import com.example.orderservice.dto.PizzaRequest;
import com.example.orderservice.dto.PizzaResponse;

public interface PizzaService {


    PizzaResponse createPizza(PizzaRequest pizzaRequest);
}
