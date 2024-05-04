package com.example.orderservice.kafka.producer;

import com.example.orderservice.dto.request.OrderForDelivery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {

    @Value("${topic.name.order}")
    private String orderTopic;

    private final KafkaTemplate<String, OrderForDelivery> kafkaTemplate;

    public void sendMessage(OrderForDelivery driver) {

        log.info("Json message send -> {}", driver.toString());
        Message<OrderForDelivery> message = MessageBuilder
                .withPayload(driver)
                .setHeader(KafkaHeaders.TOPIC, orderTopic)
                .build();
        kafkaTemplate.send(message);
    }



}
