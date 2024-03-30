package com.example.orderservice.dto.request;

import com.example.orderservice.model.Pizza;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private double price;

    private LocalDateTime dateOfOrder;

    private List<Pizza> pizzaList;

    private UUID clientId;

    private String deliveryAddress;

}
