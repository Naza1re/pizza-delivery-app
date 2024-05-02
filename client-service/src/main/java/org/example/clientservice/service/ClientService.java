package org.example.clientservice.service;

import org.example.clientservice.dto.request.ClientRequest;
import org.example.clientservice.dto.response.ClientListResponse;
import org.example.clientservice.dto.response.ClientResponse;

public interface ClientService {

    ClientResponse getClientById(Long id);

    ClientResponse createClient(ClientRequest clientRequest);

    ClientResponse updateClientById(Long id, ClientRequest clientRequest);

    ClientListResponse getAllClient();

    ClientResponse deleteById(Long id);
}
