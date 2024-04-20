package com.example.restaurantservice.mapper;

import com.example.restaurantservice.dto.RestaurantRequest;
import com.example.restaurantservice.dto.RestaurantResponse;
import com.example.restaurantservice.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantMapper {

    private final ModelMapper mapper;

    public Restaurant fromRequestToEntity(RestaurantRequest request) {
        return mapper.map(request,Restaurant.class);
    }

    public RestaurantResponse fromEntityToResponse(Restaurant restaurant) {
        return mapper.map(restaurant, RestaurantResponse.class);
    }
}
