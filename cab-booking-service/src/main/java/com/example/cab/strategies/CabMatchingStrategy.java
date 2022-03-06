package com.example.cab.strategies;

import com.example.cab.model.Cab;
import com.example.cab.model.Location;
import com.example.cab.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {

    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);

}
