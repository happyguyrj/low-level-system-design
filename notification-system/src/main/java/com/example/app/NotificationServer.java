package com.example.app;

import com.example.app.domain.Notification;
import com.example.app.middleware.Middleware;

public class NotificationServer {

    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public void sendNotification(Notification notification) {
        middleware.check(notification);
    }
}
