package com.example.orderservice.service;

import com.example.orderservice.dto.response.DeliveryManResponse;

public interface DeliveryManService {

    DeliveryManResponse changeDeliveryManStatus(Long id);
}
