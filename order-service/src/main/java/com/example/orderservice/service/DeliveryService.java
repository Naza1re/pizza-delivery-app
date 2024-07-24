package com.example.orderservice.service;

import com.example.orderservice.dto.request.DeliveryRequest;
import com.example.orderservice.dto.response.DeliveryResponse;

public interface DeliveryService {

    DeliveryResponse deliver(DeliveryRequest deliveryRequest);
}
