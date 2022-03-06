package com.example.cab.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
public class Location {
    private Double x;
    private Double y;

    public Double distance(Location location) {
        return Math.sqrt(Math.pow(this.x - location.x, 2) + Math.pow(this.y - location.y, 2));
    }
}
