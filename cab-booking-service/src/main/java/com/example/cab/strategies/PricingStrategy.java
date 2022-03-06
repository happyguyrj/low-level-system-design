package com.example.cab.strategies;

import com.example.cab.model.Location;

public interface PricingStrategy {

    Double findPrice(Location fromPoint, Location toPoint);

}
