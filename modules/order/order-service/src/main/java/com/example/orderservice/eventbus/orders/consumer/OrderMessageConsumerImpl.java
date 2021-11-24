package com.example.orderservice.eventbus.orders.consumer;

import dto.OrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class OrderMessageConsumerImpl implements OrderMessageConsumer{

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMessageConsumerImpl.class);

    @Override
    @KafkaListener(topics = "${kafka.topic.orderEvent}")
    public void consumeOrderEvents(OrderModel orderModel) {
        LOGGER.info("Message Received. otherTemplate: {}", orderModel);

    }
}
