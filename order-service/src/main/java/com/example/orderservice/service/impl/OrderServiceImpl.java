package com.example.orderservice.service.impl;

import com.example.orderservice.dto.request.OrderRequest;
import com.example.orderservice.dto.response.OrderResponse;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Pizza;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.PizzaRepository;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.utill.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PizzaRepository pizzaRepository;


    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.fromRequestToEntity(orderRequest);
        for (Pizza pizza : order.getPizzaList()) {
            Pizza managedPizza = pizzaRepository.findById(pizza.getId())
                    .orElseThrow(() -> new OrderNotFoundException(String.format(ExceptionMessages.PIZZA_NOT_FOUND,pizza.getId())));
            order.setPizzaList(List.of(managedPizza));
        }

        return orderMapper.fromEntityToResponse(orderRepository.save(order));
    }

    private Order getOrThrow(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.format(ExceptionMessages.ORDER_NOT_FOUND,id)
        ));
    }

    @Override
    public OrderResponse getOrderById(UUID id) {
        Order order = getOrThrow(id);
        return orderMapper.fromEntityToResponse(order);
    }
}
