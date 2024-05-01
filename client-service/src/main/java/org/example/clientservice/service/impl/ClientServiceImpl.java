package org.example.clientservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.clientservice.dto.response.ClientResponse;
import org.example.clientservice.exception.ClientNotFoundException;
import org.example.clientservice.model.Client;
import org.example.clientservice.repository.ClientRepository;
import org.example.clientservice.service.ClientService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private Client getOrThrow(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format(ExceptionMessages.CLIENT_NOT_FOUND,id)));
    }

    @Override
    public ClientResponse getClientById(Long id) {

    }
}
