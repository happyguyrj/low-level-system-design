package com.example.parkinglot.commands;

import com.example.parkinglot.commons.OutputPrinter;
import com.example.parkinglot.model.Command;
import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.service.ParkingLotService;
import com.example.parkinglot.strategy.NaturalOrderingParkingStrategy;
import com.example.parkinglot.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine("Created a parking lot with " + parkingLot.getCapacity() + " slots");
    }
}
