package com.example.orderservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOrderResponse {
    private Long id;
    private Long restaurantId;
    private List<Long> pizzasId;
    private Long orderId;
    private Long clientId;
}
