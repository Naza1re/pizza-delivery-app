package com.example.orderservice.service.impl;

import com.example.orderservice.client.ClientClient;
import com.example.orderservice.dto.response.ClientResponse;
import com.example.orderservice.exception.ClientNotFoundException;
import com.example.orderservice.exception.NotFoundException;
import com.example.orderservice.exception.ServiceNotAvailableException;
import com.example.orderservice.service.ClientService;
import com.example.orderservice.utill.ExceptionMessages;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientClient clientClient;
    @Override
    @CircuitBreaker(name = "client",fallbackMethod = "clientServiceFallBackMethod")
    public ClientResponse findClientById(Long id) {
        return clientClient.findClientById(id);
    }

    public ClientResponse clientServiceFallBackMethod(NotFoundException ex) {
        throw new ClientNotFoundException(ex.getMessage());
    }

    public ClientResponse clientServiceFallBackMethod(Exception ex) {
        throw new ServiceNotAvailableException(String.format(ExceptionMessages.CLIENT_SERVICE_NOT_AVAILABLE,ex.getMessage()));
    }
}
