package com.example.parkinglot.commands;

import com.example.parkinglot.commons.OutputPrinter;
import com.example.parkinglot.exception.NoFreeSlotAvailableException;
import com.example.parkinglot.model.Car;
import com.example.parkinglot.model.Command;
import com.example.parkinglot.service.ParkingLotService;
import com.example.parkinglot.validator.IntegerValidator;

import java.util.List;

public class ParkCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "park";

    public ParkCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            final Integer slot = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Allocated slot number: " + slot);
        } catch (NoFreeSlotAvailableException exception) {
            outputPrinter.parkingLotFull();
        }
    }
}
