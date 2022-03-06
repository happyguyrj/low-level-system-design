package com.example.parkinglot.model;

import com.example.parkinglot.commons.Constants;
import com.example.parkinglot.exception.InvalidSlotException;
import com.example.parkinglot.exception.ParkingLotException;
import com.example.parkinglot.exception.SlotAlreadyOccupiedException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingLot {

    private int capacity;
    private Map<Integer, Slot> slots;

    public ParkingLot(int capacity) {
        if (capacity > Constants.MAX_CAPACITY || capacity <= 0) {
            throw new ParkingLotException("Invalid capacity given for parking lot.");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    private Slot getSlot(final Integer slotNumber) {
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new InvalidSlotException();
        }
        final Map<Integer, Slot> allSlots = getSlots();
        if (!allSlots.containsKey(slotNumber)) {
            allSlots.put(slotNumber, new Slot(slotNumber));
        }
        return allSlots.get(slotNumber);
    }

    public Slot park(final Car car, final Integer slotNumber) {
        final Slot slot = getSlot(slotNumber);
        if (!slot.isSlotFree()) {
            throw new SlotAlreadyOccupiedException();
        }
        slot.assignCar(car);
        return slot;
    }

    public Slot makeSlotFree(final Integer slotNumber) {
        final Slot slot = getSlot(slotNumber);
        slot.unassignCar();
        return slot;
    }
}
