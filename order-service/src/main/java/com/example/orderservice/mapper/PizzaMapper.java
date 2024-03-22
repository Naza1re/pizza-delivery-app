package com.example.orderservice.mapper;

import com.example.orderservice.dto.PizzaRequest;
import com.example.orderservice.dto.PizzaResponse;
import com.example.orderservice.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaMapper {

    private final ModelMapper modelMapper;

    public Pizza fromRequestToEntity(PizzaRequest pizzaRequest) {
        return modelMapper.map(pizzaRequest, Pizza.class);
    }
    public PizzaResponse fromEntityToResponse(Pizza pizza) {
        return modelMapper.map(pizza,PizzaResponse.class);
    }
}
