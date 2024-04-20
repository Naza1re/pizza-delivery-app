package org.example.deliveryservice.service;

import org.example.deliveryservice.dto.DeliveryRequest;
import org.example.deliveryservice.dto.DeliveryResponse;

public interface DeliveryService {
    DeliveryResponse createDelivery(DeliveryRequest deliveryRequest);

}
