package com.example.cab.managers;

import com.example.cab.exceptions.CabAlreadyExistsException;
import com.example.cab.exceptions.CabNotFoundException;
import com.example.cab.model.Cab;
import com.example.cab.model.Location;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {

    Map<String, Cab> cabs = new HashMap<>();

    public void createCab(@NonNull Cab cab) {
        if (cabs.containsKey(cab.getId())) {
            throw new CabAlreadyExistsException();
        }

        cabs.put(cab.getId(), cab);
    }

    public Cab getCab(@NonNull final String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        return cabs.get(cabId);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setCurrentLocation(newLocation);
    }

    public void updateCabAvailability(
            @NonNull final String cabId, @NonNull final Boolean newAvailability) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setIsAvailable(newAvailability);
    }

    public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            if (cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }
}
