package org.example.deliverymanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryManRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
