package com.example.orderservice.client;

import com.example.orderservice.config.FeignClientConfiguration;
import com.example.orderservice.dto.response.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client", path = "/api/v1/client",
        configuration = FeignClientConfiguration.class)
public interface ClientClient {

    @GetMapping("/{id}")
    ClientResponse findClientById(@PathVariable Long id);
}
