package com.example.orderservice.client;

import com.example.orderservice.dto.response.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.hateoas.FeignHalAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "restaurant", path = "/api/v1/restaurant",
        configuration = FeignHalAutoConfiguration.class)
public interface RestaurantClient {
    @PostMapping()


}
