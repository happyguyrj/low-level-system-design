package com.example.app.middleware;

import com.example.app.delivery.DeliveryFactory;
import com.example.app.domain.Notification;

public class Prioritizer extends Middleware {

    private DeliveryFactory deliveryFactory;

    public Prioritizer(DeliveryFactory deliveryFactory) {
        this.deliveryFactory = deliveryFactory;
    }

    @Override
    public boolean check(Notification notification) {
        System.out.println("Performing prioritization");
        switch (notification.getPriority()) {
            case HIGH:
                return deliveryFactory.getDeliveryHandler(notification).sendNotification(notification);
            case MEDIUM:
            case LOW:
                return checkNext(notification);
            default:
                return false;
        }
    }
}
