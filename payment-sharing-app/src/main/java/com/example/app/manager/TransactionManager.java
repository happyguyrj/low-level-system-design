package com.example.app.manager;

import com.example.app.domain.User;
import com.example.app.enums.TransactionType;
import com.example.app.service.TransactionService;
import com.example.app.split.Split;
import com.example.app.transaction.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {
    List<Transaction> transactions;
    Map<Integer, User> userMap;
    Map<Integer, Map<Integer, Double> > balanceSheet;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    public Map<Integer, Map<Integer, Double>> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<Integer, Map<Integer, Double>> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addTransaction(TransactionType transactionType, double amount, Integer paidBy, List<Split> splits) {
        Transaction transaction = TransactionService.createTransaction(amount, userMap.get(paidBy), splits, transactionType);
        transactions.add(transaction);

        assert transaction != null;
        for (Split split : transaction.getSplits()) {
            Integer paidTo = split.getUser().getId();
            Map<Integer, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public void showBalance(Integer userId) {
        boolean isEmpty = true;
        for (Map.Entry<Integer, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<Integer, Map<Integer, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<Integer, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(Integer user1, Integer user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}
