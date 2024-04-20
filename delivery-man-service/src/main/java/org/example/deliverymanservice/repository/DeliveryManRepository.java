package org.example.deliverymanservice.repository;

import org.example.deliverymanservice.model.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, UUID> {
}
