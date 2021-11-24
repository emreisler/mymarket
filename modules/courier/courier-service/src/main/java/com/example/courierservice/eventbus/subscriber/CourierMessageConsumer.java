package com.example.courierservice.eventbus.subscriber;

import dto.CourierModel;

public interface CourierMessageConsumer {
    void consumeCurrierMessages(CourierModel currierModel);
}
