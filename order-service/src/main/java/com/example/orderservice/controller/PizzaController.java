package com.example.orderservice.controller;

import com.example.orderservice.dto.request.PizzaRequest;
import com.example.orderservice.dto.response.PizzaListResponse;
import com.example.orderservice.dto.response.PizzaResponse;
import com.example.orderservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping()
    public ResponseEntity<PizzaResponse> createPizza(@RequestBody PizzaRequest pizzaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pizzaService.createPizza(pizzaRequest));
    }

    @PutMapping("/{pizzaId}")
    public ResponseEntity<PizzaResponse> updatePizzaById(@RequestBody PizzaRequest pizzaRequest, @PathVariable UUID pizzaId) {
        return ResponseEntity.ok(pizzaService.updatePizzaById(pizzaId, pizzaRequest));
    }

    @GetMapping()
    public ResponseEntity<PizzaListResponse> getAllPizza() {
        return ResponseEntity.ok(pizzaService.getAllPizza());
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaResponse> getPizzaById(@PathVariable UUID pizzaId) {
        return ResponseEntity.ok(pizzaService.getPizzaById(pizzaId));
    }

    @DeleteMapping("/{pizzaId}")
    public ResponseEntity<PizzaResponse> deletePizzaById(@PathVariable UUID pizzaId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(pizzaService.deletePizzaById(pizzaId));
    }
}
