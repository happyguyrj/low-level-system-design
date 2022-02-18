package com.example.app.delivery;

import com.example.app.domain.Notification;

public class DeliveryFactory {

    public Delivery getDeliveryHandler(Notification notification) {
        switch (notification.getDeliveryChannel()) {
            case EMAIL:
                return new EmailDeliveryImpl();
            default:
                return null;
        }
    }
}
