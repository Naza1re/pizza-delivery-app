package org.example.pizzaservice.service;

import org.example.pizzaservice.dto.PizzaListResponse;
import org.example.pizzaservice.dto.PizzaRequest;
import org.example.pizzaservice.dto.PizzaResponse;

public interface PizzaService {
    PizzaListResponse getAllPizzas();

    PizzaResponse createPizza(PizzaRequest request);

    PizzaResponse updatePizza(Long id, PizzaRequest request);

    PizzaResponse getPizzaById(Long id);

    PizzaResponse deletePizzaById(Long id);
}
