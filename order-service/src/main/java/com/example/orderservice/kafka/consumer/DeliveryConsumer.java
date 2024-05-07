package com.example.orderservice.kafka.consumer;

import com.example.orderservice.dto.request.DeliveryForOrder;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryConsumer {
    private final OrderService orderService;


    @KafkaListener(topics = "${topic.name.delivery}")
    public void consume(DeliveryForOrder delivery) {
        log.info("Json message received -> {}", delivery);
        orderService.handleDeliveryMan(delivery);
    }
}
