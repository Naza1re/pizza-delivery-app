package org.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryMenResponse {

    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

}
