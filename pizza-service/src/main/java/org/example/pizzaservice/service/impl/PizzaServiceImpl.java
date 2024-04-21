package org.example.pizzaservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pizzaservice.dto.PizzaListResponse;
import org.example.pizzaservice.dto.PizzaRequest;
import org.example.pizzaservice.dto.PizzaResponse;
import org.example.pizzaservice.exception.PizzaNotFoundException;
import org.example.pizzaservice.mapper.PizzaMapper;
import org.example.pizzaservice.model.Pizza;
import org.example.pizzaservice.repository.PizzaRepository;
import org.example.pizzaservice.service.PizzaService;
import org.example.pizzaservice.util.ExceptionMessages;
import org.springframework.stereotype.Service;

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

    private Pizza getOrThrow(Long id) {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new PizzaNotFoundException(String.format(ExceptionMessages.PIZZA_NOT_FOUND, id)));
    }

    @Override
    public PizzaResponse createPizza(PizzaRequest request) {
        Pizza pizza = pizzaMapper.fromRequestToEntity(request);
        Pizza savedPizza = pizzaRepository.save(pizza);
        return pizzaMapper.fromEntityToResponse(savedPizza);
    }

    @Override
    public PizzaResponse updatePizza(Long id, PizzaRequest request) {
        Pizza pizza = getOrThrow(id);
        Pizza pizzaForSaved = pizzaMapper.fromRequestToEntity(request);
        pizzaForSaved.setId(id);
        Pizza savedPizza = pizzaRepository.save(pizzaForSaved);
        return pizzaMapper.fromEntityToResponse(savedPizza);
    }

    @Override
    public PizzaResponse getPizzaById(Long id) {
        Pizza pizza = getOrThrow(id);
        return pizzaMapper.fromEntityToResponse(pizza);
    }

    @Override
    public PizzaResponse deletePizzaById(Long id) {
        Pizza pizza = getOrThrow(id);
        pizzaRepository.delete(pizza);
        return pizzaMapper.fromEntityToResponse(pizza);
    }
}
