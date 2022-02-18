package com.example.app.middleware;

import com.example.app.domain.Notification;

public class SubscriberThrottler extends Middleware {

    private int requestPerDay;
    private int request;
    private long currentTime;

    public SubscriberThrottler(int requestPerDay) {
        this.requestPerDay = requestPerDay;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(Notification notification) {
        System.out.println("Performing client throttling");
        if (System.currentTimeMillis() > currentTime + 24*60*60*1000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;
        if (request > requestPerDay) {
            System.out.println("Client request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(notification);
    }
}
