package com.example.orderservice.eventbus.orders.publisher;

import dto.OrderModel;

public interface OrderMessageProducer {

    void sendOrderEvent(OrderModel orderModel);
}
