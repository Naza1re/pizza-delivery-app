package com.example.orderservice.client;

import com.example.orderservice.dto.request.DeliveryRequest;
import com.example.orderservice.dto.response.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.hateoas.FeignHalAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "delivery", path = "/api/v1/delivery",
        configuration = FeignHalAutoConfiguration.class)
public interface DeliveryClient {

    @PostMapping()
    DeliveryResponse createDelivery(@RequestBody DeliveryRequest deliveryRequest);
}
