package com.example.orderservice.model;

import com.example.orderservice.model.status.Status;
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

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "restaurant_id")
    private Long restaurantIdl;

    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "pizza_id")
    private List<Pizza> pizzaId;




}
