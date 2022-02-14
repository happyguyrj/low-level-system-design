package com.example.app.service;

import com.example.app.domain.User;
import com.example.app.enums.TransactionType;
import com.example.app.split.PercentSplit;
import com.example.app.split.Split;
import com.example.app.transaction.EqualTransaction;
import com.example.app.transaction.ExactTransaction;
import com.example.app.transaction.PercentTransaction;
import com.example.app.transaction.Transaction;

import java.util.List;

public class TransactionService {

    public static Transaction createTransaction(double amount, User paidBy, List<Split> splits, TransactionType transactionType) {
        switch (transactionType) {
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = amount/totalSplits;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualTransaction(amount, paidBy, splits);
            case EXACT:
                return new ExactTransaction(amount, paidBy, splits);
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new PercentTransaction(amount, paidBy, splits);
            default:
                return null;
        }
    }
}
