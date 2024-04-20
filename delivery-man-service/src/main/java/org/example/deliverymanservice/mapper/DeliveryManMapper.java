package org.example.deliverymanservice.mapper;

import lombok.RequiredArgsConstructor;
import org.example.deliverymanservice.dto.DeliveryManRequest;
import org.example.deliverymanservice.dto.DeliveryManResponse;
import org.example.deliverymanservice.model.DeliveryMan;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliveryManMapper {
    private final ModelMapper modelMapper;

    public DeliveryManResponse fromEntityToResponse(DeliveryMan deliveryMan) {
        return modelMapper.map(deliveryMan, DeliveryManResponse.class);
    }

    public DeliveryMan fromRequestToEntity(DeliveryManRequest deliveryManRequest) {
        return modelMapper.map(deliveryManRequest, DeliveryMan.class);
    }
}
