package com.example.parkinglot.commands;

import com.example.parkinglot.commons.OutputPrinter;
import com.example.parkinglot.model.Command;
import com.example.parkinglot.service.ParkingLotService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public abstract boolean validate(Command command);

    public abstract void execute(Command command);
}
