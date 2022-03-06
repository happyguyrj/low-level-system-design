package com.example.cab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Cab {
    String id;
    String driverName;
    @Setter Trip currentTrip;
    @Setter Location currentLocation;
    @Setter Boolean isAvailable;

    public Cab(String cabId, String driverName) {
        this.id = cabId;
        this.driverName = driverName;
    }
}
