package com.example.restaurantservice.service.impl;

import com.example.restaurantservice.dto.request.RestaurantOrderRequest;
import com.example.restaurantservice.dto.response.RestaurantListResponse;
import com.example.restaurantservice.dto.request.RestaurantRequest;
import com.example.restaurantservice.dto.response.RestaurantOrderResponse;
import com.example.restaurantservice.dto.response.RestaurantResponse;
import com.example.restaurantservice.exception.RestaurantAlreadyExistException;
import com.example.restaurantservice.exception.RestaurantNotFoundException;
import com.example.restaurantservice.mapper.RestaurantMapper;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.model.RestaurantOrder;
import com.example.restaurantservice.repository.RestaurantRepository;
import com.example.restaurantservice.service.RestaurantService;
import com.example.restaurantservice.util.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    @CacheEvict(cacheNames = "restaurants", allEntries = true)
    public RestaurantResponse createRestaurant(RestaurantRequest request) {

        checkRestaurantExist(request.getName());

        Restaurant restaurant = restaurantMapper.fromRequestToEntity(request);
        return restaurantMapper.fromEntityToResponse(restaurantRepository.save(restaurant));
    }

    private Restaurant getOrThrow(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(String.format(ExceptionMessages.RESTAURANT_NOT_FOUND, id)));
    }

    @Cacheable(cacheNames = "restaurants", key = "#id")
    @Override
    public RestaurantResponse getRestaurantById(Long id) {
        Restaurant restaurant = getOrThrow(id);
        return restaurantMapper.fromEntityToResponse(restaurant);
    }

    private void checkRestaurantExist(String name) {
        if (restaurantRepository.existsByName(name)) {
            throw new RestaurantAlreadyExistException(name);
        }
    }

    @Override
    @Cacheable(cacheNames = "restaurants")
    public RestaurantListResponse getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        List<RestaurantResponse> restaurantResponses = restaurants.stream()
                .map(restaurantMapper::fromEntityToResponse)
                .toList();

        return RestaurantListResponse.builder()
                .responseList(restaurantResponses)
                .build();

    }

    @CacheEvict(cacheNames = "restaurants", allEntries = true)
    @Override
    public RestaurantResponse deleteRestaurantById(Long id) {
        Restaurant restaurant = getOrThrow(id);
        restaurantRepository.delete(restaurant);
        return restaurantMapper.fromEntityToResponse(restaurant);
    }

    @CacheEvict(cacheNames = "restaurants", allEntries = true)
    @Override
    public RestaurantResponse updateRestaurantById(Long id, RestaurantRequest request) {
        Restaurant restaurant = getOrThrow(id);
        Restaurant updatedRestaurant = restaurantMapper.fromRequestToEntity(request);
        updatedRestaurant.setId(id);
        return restaurantMapper.fromEntityToResponse(restaurantRepository.save(updatedRestaurant));
    }

    @Override
    public RestaurantOrderResponse createOrder(RestaurantOrderRequest request) {
        Restaurant restaurant = getOrThrow(request.getRestaurantId());
        RestaurantOrder order = RestaurantOrder.builder()
                .orderId(request.getOrderId())

    }

}
