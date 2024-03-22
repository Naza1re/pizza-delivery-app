package com.example.orderservice.service.impl;

import com.example.orderservice.dto.PizzaRequest;
import com.example.orderservice.dto.PizzaResponse;
import com.example.orderservice.mapper.PizzaMapper;
import com.example.orderservice.model.Pizza;
import com.example.orderservice.repository.PizzaRepository;
import com.example.orderservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;
    @Override
    public PizzaResponse createPizza(PizzaRequest pizzaRequest) {
        Pizza pizza = pizzaMapper.fromRequestToEntity(pizzaRequest);
        return pizzaMapper.fromEntityToResponse(pizzaRepository.save(pizza));
    }
}
