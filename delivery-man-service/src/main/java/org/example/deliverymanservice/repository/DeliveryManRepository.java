package org.example.deliverymanservice.repository;

import org.example.deliverymanservice.model.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, UUID> {
}
