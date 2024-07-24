package com.example.orderservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryRequest {

    private Long orderId;
    private List<Long> pizzasId;
    private String deliveryAddress;
    private Long clientId;
    private Long restaurantIdToTakePizza;
}
