package org.example.deliverymanservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.deliverymanservice.dto.DeliveryManRequest;
import org.example.deliverymanservice.dto.DeliveryManResponse;
import org.example.deliverymanservice.service.DeliveryManService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/delivery-man")
public class DeliveryManController {

    private final DeliveryManService deliveryManService;

    @PostMapping
    public ResponseEntity<DeliveryManResponse> createDeliveryMan(@RequestBody DeliveryManRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(deliveryManService.createDeliveryMan(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryManResponse> getDeliveryMan(@PathVariable UUID id) {
        return ResponseEntity.ok(deliveryManService.getDeliveryManById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeliveryManResponse> deleteDeliveryMan(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(deliveryManService.deleteDeliveryManById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryManResponse> updateDeliveryMan(@PathVariable UUID id, @RequestBody DeliveryManRequest request) {
        return ResponseEntity.ok(deliveryManService.updateDeliveryManById(id,request));
    }
}
