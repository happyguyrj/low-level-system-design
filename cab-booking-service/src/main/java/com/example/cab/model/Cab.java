package com.example.cab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Cab {
    String id;
    String driverName;
    @Setter Trip currentTrip;
    @Setter Location currentLocation;
    @Setter Boolean isAvailable;
}
