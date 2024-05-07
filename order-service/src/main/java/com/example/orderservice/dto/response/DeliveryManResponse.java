package com.example.orderservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryManResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean available;
}
