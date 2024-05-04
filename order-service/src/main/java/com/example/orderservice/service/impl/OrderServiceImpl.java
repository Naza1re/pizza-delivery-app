package com.example.orderservice.service.impl;

import com.example.orderservice.dto.ListOrderResponse;
import com.example.orderservice.dto.request.DeliveryForOrder;
import com.example.orderservice.dto.request.OrderForDelivery;
import com.example.orderservice.dto.request.OrderRequest;
import com.example.orderservice.dto.response.ClientResponse;
import com.example.orderservice.dto.response.OrderResponse;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.kafka.producer.OrderProducer;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.ClientService;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.PizzaService;
import com.example.orderservice.utill.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PizzaService pizzaService;
    private final ClientService clientService;
    private final OrderProducer orderProducer;


    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        ClientResponse clientResponse = clientService.findClientById(orderRequest.getClientId());
        Order order = orderMapper.fromRequestToEntity(orderRequest);
        order.setClientName(clientResponse.getFirstName());
        calculatePrice(order, orderRequest);
        order.setDateOfOrder(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        orderProducer.sendMessage(OrderForDelivery.builder()
                .orderId(savedOrder.getId())
                .build());

        return orderMapper.fromEntityToResponse(savedOrder);
    }


    private void calculatePrice(Order order, OrderRequest request) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Long pizzaId : request.getPizzas()) {
            BigDecimal pizzaPrice = pizzaService.findPizzaById(pizzaId).getPrice();
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

    @Override
    public void handleDeliveryMan(DeliveryForOrder delivery) {
        Order order = getOrThrow(delivery.getOrderId());
        order.setDeliveryManId(delivery.getDeliveryManId());
        orderRepository.save(order);
    }
}
