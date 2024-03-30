package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.RestaurantRequest;
import com.example.restaurantservice.dto.RestaurantResponse;

public interface RestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest request);
}
