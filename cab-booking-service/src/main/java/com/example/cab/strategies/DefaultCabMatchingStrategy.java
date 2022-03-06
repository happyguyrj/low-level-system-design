package com.example.cab.strategies;

import com.example.cab.model.Cab;
import com.example.cab.model.Location;
import com.example.cab.model.Rider;
import lombok.NonNull;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

    @Override
    public Cab matchCabToRider(
            @NonNull final Rider rider,
            @NonNull final List<Cab> candidateCabs,
            @NonNull final Location fromPoint,
            @NonNull final Location toPoint) {
        return candidateCabs.get(0);
    }
}
