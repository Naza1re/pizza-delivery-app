package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.RestaurantListResponse;
import com.example.restaurantservice.dto.RestaurantRequest;
import com.example.restaurantservice.dto.RestaurantResponse;

import java.util.UUID;

public interface RestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest request);

    RestaurantResponse getRestaurantById(Long id);

    RestaurantListResponse getAllRestaurants();

    RestaurantResponse deleteRestaurantById(Long id);

    RestaurantResponse updateRestaurantById(Long id,RestaurantRequest request);
}
