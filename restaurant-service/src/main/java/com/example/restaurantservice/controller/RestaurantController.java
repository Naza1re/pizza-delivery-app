package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.request.RestaurantOrderRequest;
import com.example.restaurantservice.dto.response.RestaurantListResponse;
import com.example.restaurantservice.dto.request.RestaurantRequest;
import com.example.restaurantservice.dto.response.RestaurantOrderResponse;
import com.example.restaurantservice.dto.response.RestaurantResponse;
import com.example.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
@RestController
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(
            @RequestBody RestaurantRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restaurantService.createRestaurant(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping
    public ResponseEntity<RestaurantListResponse> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestaurantResponse> deleteRestaurant(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(restaurantService.deleteRestaurantById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(
            @PathVariable Long id, @RequestBody RestaurantRequest request) {
        return ResponseEntity.ok(restaurantService.updateRestaurantById(id,request));
    }

    @PostMapping("/order")
    public ResponseEntity<RestaurantOrderResponse> createOrderInRestaurant(
            @RequestBody RestaurantOrderRequest request
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restaurantService.createOrder(request));
    }
}
