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
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
