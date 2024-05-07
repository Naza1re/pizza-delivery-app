package org.example.deliverymanservice.service;

import org.example.deliverymanservice.dto.DeliveryManRequest;
import org.example.deliverymanservice.dto.DeliveryManResponse;

import java.util.UUID;

public interface DeliveryManService {
    DeliveryManResponse createDeliveryMan(DeliveryManRequest request);

    DeliveryManResponse getDeliveryManById(Long id);

    DeliveryManResponse deleteDeliveryManById(Long id);

    DeliveryManResponse updateDeliveryManById(Long id, DeliveryManRequest request);

    DeliveryManResponse updateStatus(Long id);
}
