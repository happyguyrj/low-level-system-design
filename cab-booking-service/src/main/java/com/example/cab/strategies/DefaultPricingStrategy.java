package com.example.cab.strategies;

import com.example.cab.commons.Constant;
import com.example.cab.model.Location;

public class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public Double findPrice(Location fromPoint, Location toPoint) {
        return fromPoint.distance(toPoint) * Constant.PER_KM_RATE;
    }
}
