package com.example.app.middleware;

import com.example.app.domain.Notification;

public abstract class Middleware {

    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(Notification notification);

    protected boolean checkNext(Notification notification) {
        if (next == null) {
            return true;
        }
        return next.check(notification);
    }
}
