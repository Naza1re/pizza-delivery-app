package com.example.orderservice.service.impl;

import com.example.orderservice.dto.response.PizzaListResponse;
import com.example.orderservice.dto.request.PizzaRequest;
import com.example.orderservice.dto.response.PizzaResponse;
import com.example.orderservice.exception.PizzaNotFoundException;
import com.example.orderservice.mapper.PizzaMapper;
import com.example.orderservice.model.Pizza;
import com.example.orderservice.repository.PizzaRepository;
import com.example.orderservice.service.PizzaService;
import com.example.orderservice.utill.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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


    private Pizza getOrThrow(UUID pizzaId) {
        return pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new PizzaNotFoundException(String.format(ExceptionMessages.PIZZA_NOT_FOUND, pizzaId)));
    }

    @Override
    public PizzaListResponse getAllPizza() {
        List<PizzaResponse> pizzaResponseList = pizzaRepository.findAll().stream()
                .map(pizzaMapper::fromEntityToResponse)
                .toList();

        return PizzaListResponse.builder()
                .pizzaResponseList(pizzaResponseList)
                .build();
    }

    @Override
    public PizzaResponse getPizzaById(UUID pizzaId) {
        Pizza pizza = getOrThrow(pizzaId);
        return pizzaMapper.fromEntityToResponse(pizza);
    }

    @Override
    public PizzaResponse deletePizzaById(UUID pizzaId) {
        Pizza pizza = getOrThrow(pizzaId);
        pizzaRepository.delete(pizza);
        return pizzaMapper.fromEntityToResponse(pizza);

    }

    @Override
    public PizzaResponse updatePizzaById(UUID pizzaId, PizzaRequest pizzaRequest) {
        Pizza pizza = getOrThrow(pizzaId);

        Pizza updatePizza = pizzaMapper.fromRequestToEntity(pizzaRequest);
        updatePizza.setId(pizzaId);

        return pizzaMapper.fromEntityToResponse(pizzaRepository.save(updatePizza));
    }


}
