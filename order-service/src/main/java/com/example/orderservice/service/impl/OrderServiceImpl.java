package com.example.orderservice.service.impl;

import com.example.orderservice.client.DeliveryClient;
import com.example.orderservice.client.PizzaClient;
import com.example.orderservice.dto.ListOrderResponse;
import com.example.orderservice.dto.request.OrderRequest;
import com.example.orderservice.dto.response.OrderResponse;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.utill.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PizzaClient pizzaClient;
    private final DeliveryClient deliveryClient;


    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.fromRequestToEntity(orderRequest);
        calculatePrice(order);


        return orderMapper.fromEntityToResponse(orderRepository.save(order));
    }


    private void calculatePrice(Order order) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Long pizzaId : order) {
            BigDecimal pizzaPrice = pizzaClient.getPizzaById(pizzaId).getPrice();
            totalPrice = totalPrice.add(pizzaPrice);
        }
        order.setPrice(totalPrice);
    }

    private Order getOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.format(ExceptionMessages.ORDER_NOT_FOUND, id)
                ));
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = getOrThrow(id);
        return orderMapper.fromEntityToResponse(order);
    }

    @Override
    public ListOrderResponse getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        List<OrderResponse> orderResponseList = allOrders
                .stream()
                .map(orderMapper::fromEntityToResponse)
                .toList();
        return new ListOrderResponse(orderResponseList);
    }
}
