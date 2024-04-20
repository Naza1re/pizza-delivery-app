package org.example.pizzaservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.pizzaservice.dto.PizzaListResponse;
import org.example.pizzaservice.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<PizzaListResponse> getAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }
}
