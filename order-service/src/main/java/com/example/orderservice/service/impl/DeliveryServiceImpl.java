package com.example.orderservice.service.impl;

import com.example.orderservice.client.DeliveryClient;
import com.example.orderservice.dto.request.DeliveryRequest;
import com.example.orderservice.dto.response.DeliveryResponse;
import com.example.orderservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryClient deliveryClient;
    @Override
    public DeliveryResponse deliver(DeliveryRequest deliveryRequest) {
        return deliveryClient.createDelivery(deliveryRequest);
    }
}
