package com.example.orderservice.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private List<Long> pizzas;
    private Long clientId;
    private String deliveryAddress;


}
