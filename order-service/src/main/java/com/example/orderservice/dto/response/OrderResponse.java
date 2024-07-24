package com.example.orderservice.dto.response;

import com.example.orderservice.model.status.Status;
import com.example.orderservice.model.typedelivery.GettingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;
    private BigDecimal price;
    private Long clientId;
    private String deliveryAddress;
    private Long restaurantIdl;
    private LocalDateTime dateOfOrder;
    private Status status;
    private Long deliveryManId;
    private GettingType gettingType;
}
