package org.example.pizzaservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.pizzaservice.dto.PizzaListResponse;
import org.example.pizzaservice.dto.PizzaRequest;
import org.example.pizzaservice.dto.PizzaResponse;
import org.example.pizzaservice.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<PizzaListResponse> getAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @PostMapping
    public ResponseEntity<PizzaResponse> createPizza(@RequestBody PizzaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pizzaService.createPizza(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaResponse> updatePizza(@PathVariable Long id, @RequestBody PizzaRequest request) {
        return ResponseEntity.ok(pizzaService.updatePizza(id,request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaResponse> getPizzaById(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaService.getPizzaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PizzaResponse> deletePizza(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(pizzaService.deletePizzaById(id));
    }
}
