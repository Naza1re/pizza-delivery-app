package org.example.deliverymanservice.service;

import org.example.deliverymanservice.dto.DeliveryManRequest;
import org.example.deliverymanservice.dto.DeliveryManResponse;

import java.util.UUID;

public interface DeliveryManService {
    DeliveryManResponse createDeliveryMan(DeliveryManRequest request);

    DeliveryManResponse getDeliveryManById(UUID id);

    DeliveryManResponse deleteDeliveryManById(UUID id);

    DeliveryManResponse updateDeliveryManById(UUID id, DeliveryManRequest request);
}
