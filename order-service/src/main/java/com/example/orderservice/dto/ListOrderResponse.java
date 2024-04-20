package com.example.orderservice.dto;


import com.example.orderservice.dto.response.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ListOrderResponse {
    private List<OrderResponse> orders;
}
