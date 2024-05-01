package org.example.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.clientservice.dto.response.ClientResponse;
import org.example.clientservice.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }
}
