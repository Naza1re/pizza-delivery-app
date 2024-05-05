package com.example.orderservice.client;

import com.example.orderservice.config.FeignClientConfiguration;
import com.example.orderservice.dto.response.DeliveryManResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "deliveryMan", path = "/api/v1/delivery-man",
        configuration = FeignClientConfiguration.class)
public interface DeliveryManClient {

    @PutMapping("/status/{id}")
    DeliveryManResponse changeDeliveryManStatus(@PathVariable Long id);
}
