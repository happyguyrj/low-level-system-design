package com.example.cab.model;

import lombok.NonNull;
import lombok.ToString;

enum TripStatus{
    IN_PROGRESS,
    FINISHED
}

@ToString
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus status;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(@NonNull Rider rider,
                @NonNull Cab cab,
                @NonNull Double price,
                @NonNull Location fromPoint,
                @NonNull Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.status = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.status = TripStatus.FINISHED;
    }
}
