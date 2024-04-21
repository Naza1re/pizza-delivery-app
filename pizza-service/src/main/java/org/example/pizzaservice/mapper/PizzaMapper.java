package org.example.pizzaservice.mapper;

import org.example.pizzaservice.dto.PizzaRequest;
import org.example.pizzaservice.dto.PizzaResponse;
import org.example.pizzaservice.model.Pizza;
import org.example.pizzaservice.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PizzaMapper {
    private final ModelMapper modelMapper;

    public PizzaResponse fromEntityToResponse(Pizza pizza) {
        return modelMapper.map(pizza, PizzaResponse.class);
    }
    public Pizza fromRequestToEntity(PizzaRequest pizzaRequest) {
        return modelMapper.map(pizzaRequest, Pizza.class);
    }
}
