package com.example.orderservice.client;

import com.example.orderservice.config.FeignClientConfiguration;
import com.example.orderservice.dto.response.RestaurantListResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "restaurant",
        path = "/api/v1/restaurant",
        configuration = FeignClientConfiguration.class)
public interface RestaurantClient {

    @GetMapping()
    RestaurantListResponse getRestaurantList();
}
