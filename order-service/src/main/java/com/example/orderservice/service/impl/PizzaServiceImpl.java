package com.example.orderservice.service.impl;

import com.example.orderservice.client.PizzaClient;
import com.example.orderservice.dto.response.PizzaResponse;
import com.example.orderservice.exception.NotFoundException;
import com.example.orderservice.exception.PizzaNotFoundException;
import com.example.orderservice.service.PizzaService;
import com.example.orderservice.utill.ExceptionMessages;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.internal.ServiceDependencyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaClient pizzaClient;
    @Override
    @CircuitBreaker(name = "pizza", fallbackMethod = "pizzaFallBackMethod")
    public PizzaResponse findPizzaById(Long id) {
        return pizzaClient.getPizzaById(id);
    }

    public PizzaResponse pizzaFallBackMethod(NotFoundException ex) {
        throw new PizzaNotFoundException(ex.getMessage());
    }

    public PizzaResponse pizzaFallBackMethod(Exception ex) {
        throw new ServiceDependencyException(String.format(ExceptionMessages.PIZZA_SERVICE_NOT_AVAILABLE,ex.getMessage()));
    }
}
