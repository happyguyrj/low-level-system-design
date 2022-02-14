package com.example.app;

import com.example.app.domain.User;
import com.example.app.enums.TransactionType;
import com.example.app.manager.TransactionManager;
import com.example.app.split.EqualSplit;
import com.example.app.split.ExactSplit;
import com.example.app.split.PercentSplit;
import com.example.app.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		TransactionManager transactionManager = new TransactionManager();
		transactionManager.addUser(new User(1, "User1", "", ""));
		transactionManager.addUser(new User(2, "User2", "", ""));
		transactionManager.addUser(new User(3, "User3", "", ""));
		transactionManager.addUser(new User(4, "User4", "", ""));

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String command = scanner.nextLine();
			String[] commands = command.split(" ");
			String commandType = commands[0];

			switch (commandType) {
				case "SHOW":
					if (commands.length == 1) {
						transactionManager.showBalances();
					} else {
						transactionManager.showBalance(Integer.valueOf(commands[1]));
					}
					break;
				case "EXPENSE":
					Integer paidBy = Integer.valueOf(commands[1]);
					double amount = Double.parseDouble(commands[2]);
					int noOfUsers = Integer.parseInt(commands[3]);
					String expenseType = commands[4 + noOfUsers];
					List<Split> splits = new ArrayList<>();
					switch (expenseType) {
						// EXPENSE 1 1000 4 1 2 3 4 EQUAL
						case "EQUAL":
							for (int i = 0; i < noOfUsers; i++) {
								splits.add(new EqualSplit(transactionManager.getUserMap().get(Integer.valueOf(commands[4 + i]))));
							}
							transactionManager.addTransaction(TransactionType.EQUAL, amount, paidBy, splits);
							break;
						case "EXACT":
							// EXPENSE 1 1000 2 1 2 EXACT 120 880
							for (int i = 0; i < noOfUsers; i++) {
								splits.add(new ExactSplit(transactionManager.getUserMap().get(Integer.valueOf(commands[4 + i])), Double.parseDouble(commands[5 + noOfUsers + i])));
							}
							transactionManager.addTransaction(TransactionType.EXACT, amount, paidBy, splits);
							break;
						case "PERCENT":
							// EXPENSE 4 1000 4 1 2 3 4 PERCENT 10 20 30 40
							for (int i = 0; i < noOfUsers; i++) {
								splits.add(new PercentSplit(transactionManager.getUserMap().get(Integer.valueOf(commands[4 + i])), Double.parseDouble(commands[5 + noOfUsers + i])));
							}
							transactionManager.addTransaction(TransactionType.PERCENT, amount, paidBy, splits);
							break;
					}
					break;
			}
		}
	}
}
