package org.example.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.clientservice.dto.request.ClientRequest;
import org.example.clientservice.dto.response.ClientListResponse;
import org.example.clientservice.dto.response.ClientResponse;
import org.example.clientservice.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientService.createClient(clientRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok(clientService.updateClientById(id, clientRequest));
    }

    @GetMapping
    public ResponseEntity<ClientListResponse> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClient());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(clientService.deleteById(id));
    }
}
