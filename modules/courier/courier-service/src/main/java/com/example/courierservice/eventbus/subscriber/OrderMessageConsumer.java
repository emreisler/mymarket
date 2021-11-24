package com.example.courierservice.eventbus.subscriber;

import dto.OrderModel;

public interface OrderMessageConsumer {
    void consumeOrderMessages(OrderModel orderModel);
}
