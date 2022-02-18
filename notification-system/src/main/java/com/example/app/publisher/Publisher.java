package com.example.app.publisher;

public class Publisher {

    private int id;
    private String name;
    private int requestPerDay;

    public Publisher(int id, String name, int requestPerDay) {
        this.id = id;
        this.name = name;
        this.requestPerDay = requestPerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequestPerDay() {
        return requestPerDay;
    }

    public void setRequestPerDay(int requestPerDay) {
        this.requestPerDay = requestPerDay;
    }
}
