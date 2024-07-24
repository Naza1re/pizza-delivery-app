package com.example.orderservice.service.impl;

import com.example.orderservice.client.RestaurantClient;
import com.example.orderservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantClient restaurantClient;


}
