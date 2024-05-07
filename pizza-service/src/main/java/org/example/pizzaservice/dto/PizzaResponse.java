package org.example.pizzaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PizzaResponse {
    private Long id;
    private String name;
    private String description;
    private String size;
}
