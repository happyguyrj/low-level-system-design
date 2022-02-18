package com.example.app.delivery;

import com.example.app.domain.Notification;

public interface Delivery {

    boolean sendNotification(Notification notification);
}
