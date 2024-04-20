package com.example.orderservice.config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FeignClientConfiguration {

    @Bean
    public ErrorDecoder feignDecoder() {
        return new MyDecoder();
    }
}
