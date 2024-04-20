package org.example.deliveryservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.deliveryservice.dto.DeliveryRequest;
import org.example.deliveryservice.dto.DeliveryResponse;
import org.example.deliveryservice.model.Delivery;
import org.example.deliveryservice.model.status.Status;
import org.example.deliveryservice.repository.DeliveryRepository;
import org.example.deliveryservice.service.DeliveryService;
import org.example.deliveryservice.mapper.DeliveryMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Override
    public DeliveryResponse createDelivery(DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryMapper.fromRequestToEntity(deliveryRequest);
        delivery.setStatus(Status.ACTIVE);
        deliveryRepository.save(delivery);
        return deliveryMapper.toDeliveryResponse(delivery);
    }
}
