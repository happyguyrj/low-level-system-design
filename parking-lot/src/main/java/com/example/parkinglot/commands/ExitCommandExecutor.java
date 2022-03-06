package com.example.parkinglot.commands;

import com.example.parkinglot.commons.OutputPrinter;
import com.example.parkinglot.model.Command;
import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.service.ParkingLotService;
import com.example.parkinglot.strategy.NaturalOrderingParkingStrategy;
import com.example.parkinglot.validator.IntegerValidator;

import java.util.List;

public class ExitCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        outputPrinter.end();
    }
}
