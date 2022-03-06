package com.example.cab.managers;

import com.example.cab.exceptions.RiderAlreadyExistsException;
import com.example.cab.exceptions.RiderNotFoundException;
import com.example.cab.model.Rider;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {

    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NonNull final Rider rider) {
        if (riders.containsKey(rider.getId())) {
            throw new RiderAlreadyExistsException();
        }

        riders.put(rider.getId(), rider);
    }

    public Rider getRider(@NonNull final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
}
