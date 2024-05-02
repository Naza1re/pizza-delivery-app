package org.example.clientservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.clientservice.dto.request.ClientRequest;
import org.example.clientservice.dto.response.ClientListResponse;
import org.example.clientservice.dto.response.ClientResponse;
import org.example.clientservice.exception.ClientAlreadyExistException;
import org.example.clientservice.exception.ClientNotFoundException;
import org.example.clientservice.mapper.ClientMapper;
import org.example.clientservice.model.Client;
import org.example.clientservice.repository.ClientRepository;
import org.example.clientservice.service.ClientService;
import org.example.clientservice.util.ExceptionMessages;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    private Client getOrThrow(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format(ExceptionMessages.CLIENT_NOT_FOUND, id)));
    }

    @Override
    public ClientResponse getClientById(Long id) {
        Client client = getOrThrow(id);
        return clientMapper.fromEntityToResponse(client);
    }

    private void checkPhoneAlreadyExist(String phone) {
        if (clientRepository.existsByPhone(phone)) {
            throw new ClientAlreadyExistException(String.format(ExceptionMessages.CLIENT_ALREADY_EXIST_WITH_PHONE, phone));
        }
    }

    private void checkClientAlreadyExist(Client client) {
        checkPhoneAlreadyExist(client.getPhone());
        checkEmailAlreadyExist(client.getEmail());
    }

    private void checkEmailAlreadyExist(String email) {
        if (clientRepository.existsByEmail(email)) {
            throw new ClientAlreadyExistException(String.format(ExceptionMessages.CLIENT_ALREADY_EXIST_WITH_EMAIL, email));
        }
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = clientMapper.fromRequestToEntity(clientRequest);
        checkClientAlreadyExist(client);
        return clientMapper.fromEntityToResponse(clientRepository.save(client));
    }

    @Override
    public ClientResponse updateClientById(Long id, ClientRequest clientRequest) {
        Client client = getOrThrow(id);
        Client clientToSave = clientMapper.fromRequestToEntity(clientRequest);
        clientToSave.setId(client.getId());
        return clientMapper.fromEntityToResponse(clientRepository.save(clientToSave));
    }

    @Override
    public ClientListResponse  getAllClient() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> clientResponseList = clients.stream()
                .map(clientMapper::fromEntityToResponse)
                .toList();
        return new ClientListResponse(clientResponseList);
    }

    @Override
    public ClientResponse deleteById(Long id) {
        Client client = getOrThrow(id);
        clientRepository.delete(client);
        return clientMapper.fromEntityToResponse(client);
    }
}
