package org.example.pizzaservice.repository;

import org.example.pizzaservice.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
