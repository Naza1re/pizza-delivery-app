package com.example.restaurantservice.service.impl;

import com.example.restaurantservice.dto.RestaurantRequest;
import com.example.restaurantservice.dto.RestaurantResponse;
import com.example.restaurantservice.mapper.RestaurantMapper;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.repository.RestaurantRepository;
import com.example.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request) {

        Restaurant restaurant = restaurantMapper.fromRequestToEntity(request);
        return restaurantMapper.fromEntityToResponse(restaurantRepository.save(restaurant));
    }
}
