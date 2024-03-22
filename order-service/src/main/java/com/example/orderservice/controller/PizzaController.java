package com.example.orderservice.controller;

import com.example.orderservice.dto.PizzaList;
import com.example.orderservice.dto.PizzaRequest;
import com.example.orderservice.dto.PizzaResponse;
import com.example.orderservice.service.PizzaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
