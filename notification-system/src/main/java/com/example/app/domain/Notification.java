package com.example.app.domain;

public class Notification {

    private Integer publisherId;
    private Integer clientId;
    private String message;
    private Priority priority;
    private DeliveryChannel deliveryChannel;

    public Notification(Integer publisherId, Integer clientId, String message, Priority priority, DeliveryChannel deliveryChannel) {
        this.publisherId = publisherId;
        this.clientId = clientId;
        this.message = message;
        this.priority = priority;
        this.deliveryChannel = deliveryChannel;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public DeliveryChannel getDeliveryChannel() {
        return deliveryChannel;
    }

    public void setDeliveryChannel(DeliveryChannel deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }
}
