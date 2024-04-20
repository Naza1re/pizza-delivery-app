package com.example.orderservice.dto.request;

import com.example.orderservice.dto.response.PizzaListResponse;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private double price;

    private LocalDateTime dateOfOrder;

    private PizzaListResponse pizzaListResponse;

    private UUID clientId;

    private String deliveryAddress;

}
