package com.example.orderservice.eventbus.orders.publisher;

import dto.OrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class OrderMessageProducerImpl implements OrderMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMessageProducerImpl.class);

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Value(value = "${kafka.topic.orderEvent}")
    private String orderEventTopic;

    @Override
    @Async
    public void sendOrderEvent(OrderModel orderModel) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(orderEventTopic, orderModel);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Unable to send message='{}'", orderEventTopic, ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                LOGGER.error("Sent message='{}' with offset={}", orderEventTopic, result.getRecordMetadata().offset());
            }
        });
    }
}
