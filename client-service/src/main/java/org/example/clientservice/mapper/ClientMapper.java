package org.example.clientservice.mapper;

import lombok.RequiredArgsConstructor;
import org.example.clientservice.dto.request.ClientRequest;
import org.example.clientservice.dto.response.ClientResponse;
import org.example.clientservice.model.Client;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMapper {
    private final ModelMapper modelMapper;


    public Client fromRequestToEntity(ClientRequest request) {
        return modelMapper.map(request,Client.class);
    }
    public ClientResponse fromEntityToResponse(Client client) {
        return modelMapper.map(client,ClientResponse.class);
    }
}
