package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.request.RestaurantOrderRequest;
import com.example.restaurantservice.dto.response.RestaurantListResponse;
import com.example.restaurantservice.dto.request.RestaurantRequest;
import com.example.restaurantservice.dto.response.RestaurantOrderResponse;
import com.example.restaurantservice.dto.response.RestaurantResponse;

public interface RestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest request);

    RestaurantResponse getRestaurantById(Long id);

    RestaurantListResponse getAllRestaurants();

    RestaurantResponse deleteRestaurantById(Long id);

    RestaurantResponse updateRestaurantById(Long id,RestaurantRequest request);

    RestaurantOrderResponse createOrder(RestaurantOrderRequest request);
}
