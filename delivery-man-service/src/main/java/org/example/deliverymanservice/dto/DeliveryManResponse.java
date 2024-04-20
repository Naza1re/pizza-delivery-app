package org.example.deliverymanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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

}
