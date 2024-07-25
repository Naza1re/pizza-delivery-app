package com.example.restaurantservice.dto.request;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOrderRequest {
    private Long restaurantId;
    private List<Long> pizzasId;
    private Long orderId;
    private Long clientId;
}
