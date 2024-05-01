package org.example.clientservice.service;

import org.example.clientservice.dto.response.ClientResponse;

public interface ClientService {

    ClientResponse getClientById(Long id);
}
