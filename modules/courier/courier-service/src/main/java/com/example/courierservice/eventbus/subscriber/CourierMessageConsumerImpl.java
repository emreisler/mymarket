package com.example.courierservice.eventbus.subscriber;

import dto.CourierModel;
import org.springframework.kafka.annotation.KafkaListener;

public class CourierMessageConsumerImpl implements CourierMessageConsumer{

    @Override
    @KafkaListener(topics = "${kafka.topic.courierEvent}")
    public void consumeCurrierMessages(CourierModel currierModel) {

    }
}
