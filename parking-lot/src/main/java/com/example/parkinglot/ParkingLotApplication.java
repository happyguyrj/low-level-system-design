package com.example.parkinglot;

import com.example.parkinglot.commands.CommandExecutorFactory;
import com.example.parkinglot.commons.OutputPrinter;
import com.example.parkinglot.exception.InvalidModeException;
import com.example.parkinglot.mode.FileMode;
import com.example.parkinglot.mode.InteractiveMode;
import com.example.parkinglot.service.ParkingLotService;

import java.io.IOException;

public class ParkingLotApplication {

	public static void main(String[] args) throws IOException {
		final OutputPrinter outputPrinter = new OutputPrinter();
		final ParkingLotService parkingLotService = new ParkingLotService();
		final CommandExecutorFactory commandExecutorFactory =
				new CommandExecutorFactory(parkingLotService);

		if (isInteractiveMode(args)) {
			new InteractiveMode(commandExecutorFactory, outputPrinter).process();
		} else if (isFileInputMode(args)) {
			new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
		} else {
			throw new InvalidModeException();
		}
	}

	private static boolean isFileInputMode(final String[] args) {
		return args.length == 1;
	}

	private static boolean isInteractiveMode(final String[] args) {
		return args.length == 0;
	}
}
