package com.example.orderservice.service;

import com.example.orderservice.dto.ListOrderResponse;
import com.example.orderservice.dto.request.DeliveryForOrder;
import com.example.orderservice.dto.request.OrderRequest;
import com.example.orderservice.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(Long id);

    ListOrderResponse getAllOrders();

    void handleDeliveryMan(DeliveryForOrder delivery);
}
