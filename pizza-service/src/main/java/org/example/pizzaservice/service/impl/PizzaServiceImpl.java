package org.example.pizzaservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pizzaservice.dto.PizzaListResponse;
import org.example.pizzaservice.dto.PizzaResponse;
import org.example.pizzaservice.model.Pizza;
import org.example.pizzaservice.repository.PizzaRepository;
import org.example.pizzaservice.service.PizzaService;
import org.example.pizzaservice.service.mapper.PizzaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    @Override
    public PizzaListResponse getAllPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaResponse> pizzaResponses = pizzas.stream()
                .map(pizzaMapper::fromEntityToResponse)
                .toList();
        return new PizzaListResponse(pizzaResponses);
    }
}
