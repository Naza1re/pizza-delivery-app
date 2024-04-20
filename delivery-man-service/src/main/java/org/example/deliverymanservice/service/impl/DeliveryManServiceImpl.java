package org.example.deliverymanservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.deliverymanservice.dto.DeliveryManRequest;
import org.example.deliverymanservice.dto.DeliveryManResponse;
import org.example.deliverymanservice.exception.DeliveryManNotFoundException;
import org.example.deliverymanservice.mapper.DeliveryManMapper;
import org.example.deliverymanservice.model.DeliveryMan;
import org.example.deliverymanservice.repository.DeliveryManRepository;
import org.example.deliverymanservice.service.DeliveryManService;
import org.example.deliverymanservice.util.ExceptionMessages;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryManServiceImpl implements DeliveryManService {

    private final DeliveryManRepository deliveryManRepository;
    private final DeliveryManMapper deliveryManMapper;

    @Override
    public DeliveryManResponse createDeliveryMan(DeliveryManRequest request) {

        DeliveryMan deliveryMan = deliveryManMapper.fromRequestToEntity(request);
        DeliveryMan savedDeliveryMan = deliveryManRepository.save(deliveryMan);
        return deliveryManMapper.fromEntityToResponse(savedDeliveryMan);
    }


    private DeliveryMan getOrThrow(UUID id) {
        return deliveryManRepository.findById(id)
                .orElseThrow(() -> new DeliveryManNotFoundException(String.format(ExceptionMessages.DELIVERY_MAN_NOT_FOUND, id)));
    }

    @Override
    public DeliveryManResponse getDeliveryManById(UUID id) {
        DeliveryMan deliveryMan = getOrThrow(id);
        return deliveryManMapper.fromEntityToResponse(deliveryMan);
    }

    @Override
    public DeliveryManResponse deleteDeliveryManById(UUID id) {
        DeliveryMan deliveryMan = getOrThrow(id);

        deliveryManRepository.delete(deliveryMan);
        return deliveryManMapper.fromEntityToResponse(deliveryMan);
    }

    @Override
    public DeliveryManResponse updateDeliveryManById(UUID id, DeliveryManRequest request) {
        DeliveryMan deliveryMan = getOrThrow(id);
        DeliveryMan updatedDeliveryMan = deliveryManMapper.fromRequestToEntity(request);
        updatedDeliveryMan.setId(id);
        return deliveryManMapper.fromEntityToResponse(deliveryManRepository.save(updatedDeliveryMan));
    }
}
