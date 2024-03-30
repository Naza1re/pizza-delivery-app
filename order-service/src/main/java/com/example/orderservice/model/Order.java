package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double price;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "restaurant_id")
    private UUID restaurantIdl;

    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza")
    private List<Pizza> pizzaList;


}
