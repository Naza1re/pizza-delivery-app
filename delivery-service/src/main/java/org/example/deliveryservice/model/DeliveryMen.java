package org.example.deliveryservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "delivery_men")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryMen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    @OneToMany
    @JoinColumn(name = "delivery_id")
    private List<Delivery> listOfDeliveries;


}
