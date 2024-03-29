package com.example.orderservice.service;

import com.example.orderservice.dto.response.PizzaListResponse;
import com.example.orderservice.dto.request.PizzaRequest;
import com.example.orderservice.dto.response.PizzaResponse;

import java.util.UUID;

public interface PizzaService {


    PizzaResponse createPizza(PizzaRequest pizzaRequest);

    PizzaListResponse getAllPizza();

    PizzaResponse getPizzaById(UUID pizzaId);

    PizzaResponse deletePizzaById(UUID pizzaId);

    PizzaResponse updatePizzaById(UUID pizzaId, PizzaRequest pizzaRequest);
}
