package com.example.restaurantservice.dto.response;


import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PizzaListResponse {
    private List<PizzaResponse> pizzas;
}
