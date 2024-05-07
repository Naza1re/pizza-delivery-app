package com.example.orderservice.service.impl;

import com.example.orderservice.client.DeliveryManClient;
import com.example.orderservice.dto.response.DeliveryManResponse;
import com.example.orderservice.exception.DeliveryManNotFoundException;
import com.example.orderservice.exception.NotFoundException;
import com.example.orderservice.exception.ServiceNotAvailableException;
import com.example.orderservice.service.DeliveryManService;
import com.example.orderservice.utill.ExceptionMessages;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryManServiceImpl implements DeliveryManService {

    private final DeliveryManClient deliveryManClient;


    @CircuitBreaker(name = "delivery_man",fallbackMethod = "deliveryManClientFallBackMethod")
    @Override
    public DeliveryManResponse changeDeliveryManStatus(Long id) {
        return deliveryManClient.changeDeliveryManStatus(id);
    }

    public DeliveryManResponse deliveryManClientFallBackMethod(NotFoundException ex) {
        throw new DeliveryManNotFoundException(ex.getMessage());
    }

    public DeliveryManResponse deliveryManClientFallBackMethod(Exception ex) {
        throw new ServiceNotAvailableException(String.format(ExceptionMessages.DELIVERY_MAN_SERVICE_NOT_AVAILABLE,ex.getMessage()));
    }


}
