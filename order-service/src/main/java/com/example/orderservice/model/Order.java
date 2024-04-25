package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;

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




}
