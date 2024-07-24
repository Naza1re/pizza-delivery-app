package com.example.orderservice.dto.request;

import com.example.orderservice.model.typedelivery.GettingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private List<Long> pizzas;
    private Long clientId;
    private String deliveryAddress;
    private Long restaurantIdl;
    private GettingType gettingType;


}
