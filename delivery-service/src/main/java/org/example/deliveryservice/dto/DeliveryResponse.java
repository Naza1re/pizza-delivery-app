package org.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.deliveryservice.model.DeliveryMen;
import org.example.deliveryservice.model.status.Status;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryResponse {

    private UUID id;
    private UUID orderID;
    private Status status;
    private DeliveryMen deliveryMen;


}
