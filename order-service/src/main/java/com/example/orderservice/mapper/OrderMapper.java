package com.example.orderservice.mapper;


import com.example.orderservice.dto.request.OrderRequest;
import com.example.orderservice.dto.response.OrderResponse;
import com.example.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper mapper;


    public OrderResponse fromEntityToResponse(Order order) {
        return mapper.map(order, OrderResponse.class);
    }

    public Order fromRequestToEntity(OrderRequest request) {
        return mapper.map(request, Order.class);
    }
}
