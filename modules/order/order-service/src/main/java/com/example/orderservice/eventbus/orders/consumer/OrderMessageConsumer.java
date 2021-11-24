package com.example.orderservice.eventbus.orders.consumer;

import dto.OrderModel;

public interface OrderMessageConsumer {

    void consumeOrderEvents(OrderModel orderModel);
}
