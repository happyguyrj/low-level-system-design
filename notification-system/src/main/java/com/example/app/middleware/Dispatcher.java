package com.example.app.middleware;

import com.example.app.delivery.DeliveryFactory;
import com.example.app.domain.Notification;

public class Dispatcher extends Middleware {

    private DeliveryFactory deliveryFactory;

    public Dispatcher(DeliveryFactory deliveryFactory) {
        this.deliveryFactory = deliveryFactory;
    }

    @Override
    public boolean check(Notification notification) {
        deliveryFactory.getDeliveryHandler(notification).sendNotification(notification);
        return checkNext(notification);
    }
}
