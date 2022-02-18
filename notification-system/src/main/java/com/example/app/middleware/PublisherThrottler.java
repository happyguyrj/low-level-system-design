package com.example.app.middleware;

import com.example.app.domain.Notification;
import com.example.app.publisher.Publisher;

import java.util.Map;

public class PublisherThrottler extends Middleware {

    private Map<Integer, Publisher> publisherMap;
    private int request;
    private long currentTime;

    public PublisherThrottler(Map<Integer, Publisher> publisherMap) {
        this.publisherMap = publisherMap;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(Notification notification) {
        System.out.println("Performing publisher throttling");
        if (System.currentTimeMillis() > currentTime + 24*60*60*1000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;
        if (request > publisherMap.get(notification.getPublisherId()).getRequestPerDay()) {
            System.out.println(" Publisher request limit exceeded!");
            Thread.currentThread().stop();
            return false;
        }
        return checkNext(notification);
    }
}
