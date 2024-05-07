package com.example.orderservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PizzaResponse {
    private Long id;
    private String name;
    private String size;
    private BigDecimal price;
}
