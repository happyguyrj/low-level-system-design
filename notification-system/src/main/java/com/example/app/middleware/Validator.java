package com.example.app.middleware;

import com.example.app.domain.Notification;

import java.util.Objects;

public class Validator extends Middleware {

    @Override
    public boolean check(Notification notification) {
        System.out.println("Performing validation");
        return Objects.nonNull(notification.getPublisherId())
                && Objects.nonNull(notification.getClientId())
                && Objects.nonNull(notification.getPriority())
                && Objects.nonNull(notification.getDeliveryChannel())
                && Objects.nonNull(notification.getMessage())
                && checkNext(notification);
    }
}
