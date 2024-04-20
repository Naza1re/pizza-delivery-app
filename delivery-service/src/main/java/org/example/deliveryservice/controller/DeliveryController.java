package org.example.deliveryservice.controller;


import lombok.RequiredArgsConstructor;
import org.example.deliveryservice.dto.DeliveryRequest;
import org.example.deliveryservice.dto.DeliveryResponse;
import org.example.deliveryservice.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;


    @PostMapping
    public ResponseEntity<DeliveryResponse> deliveryResponse(@RequestBody DeliveryRequest deliveryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(deliveryService.createDelivery(deliveryRequest));
    }



}
