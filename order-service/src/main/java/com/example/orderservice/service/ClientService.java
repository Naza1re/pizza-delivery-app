package com.example.orderservice.service;

import com.example.orderservice.dto.response.ClientResponse;

public interface ClientService {
    ClientResponse findClientById(Long id);
}
