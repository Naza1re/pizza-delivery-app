package com.example.orderservice.service;

import com.example.orderservice.dto.response.PizzaResponse;

public interface PizzaService {
    PizzaResponse findPizzaById(Long id);
}
