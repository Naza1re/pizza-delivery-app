package com.example.orderservice.client;

import com.example.orderservice.config.FeignClientConfiguration;
import com.example.orderservice.dto.response.PizzaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pizza",
        path = "/api/v1/pizza", configuration = FeignClientConfiguration.class)
public interface PizzaClient {

    @GetMapping("/{id}")
    PizzaResponse getPizzaById(@PathVariable("id") Long id);
}
