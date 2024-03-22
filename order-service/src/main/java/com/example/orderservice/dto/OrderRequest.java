package com.example.orderservice.dto;

import com.example.orderservice.model.Pizza;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private double price;

    private LocalDateTime dateOfOrder;

    private List<Pizza> pizzaList;

}
