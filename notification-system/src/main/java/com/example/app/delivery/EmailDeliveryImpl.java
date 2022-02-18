package com.example.app.delivery;

import com.example.app.domain.Notification;

public class EmailDeliveryImpl implements Delivery {

    @Override
    public boolean sendNotification(Notification notification) {
        System.out.println("Sent email");
        return true;
    }
}
