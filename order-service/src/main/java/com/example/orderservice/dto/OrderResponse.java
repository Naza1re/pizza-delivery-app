package com.example.orderservice.dto;

import com.example.orderservice.model.Pizza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private UUID id;
    private double price;
    private LocalDateTime dateOfOrder;
    private List<PizzaResponse> pizzaList;
}
