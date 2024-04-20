package org.example.deliveryservice.mapper;

import lombok.RequiredArgsConstructor;
import org.example.deliveryservice.dto.DeliveryRequest;
import org.example.deliveryservice.dto.DeliveryResponse;
import org.example.deliveryservice.model.Delivery;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryMapper {

    private final ModelMapper modelMapper;

    public Delivery fromRequestToEntity(DeliveryRequest deliveryRequest) {
        return modelMapper.map(deliveryRequest,Delivery.class);
    }

    public DeliveryResponse toDeliveryResponse(Delivery delivery) {
        return modelMapper.map(delivery,DeliveryResponse.class);
    }
}
