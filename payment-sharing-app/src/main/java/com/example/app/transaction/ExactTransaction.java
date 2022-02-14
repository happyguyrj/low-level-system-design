package com.example.app.transaction;

import com.example.app.domain.User;
import com.example.app.split.EqualSplit;
import com.example.app.split.ExactSplit;
import com.example.app.split.Split;

import java.util.List;

public class ExactTransaction extends Transaction {

    public ExactTransaction(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        double totalAmount = getAmount();
        double sumAmount = 0;

        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
            ExactSplit exactSplit = (ExactSplit) split;
            sumAmount += exactSplit.getAmount();
        }

        return totalAmount==sumAmount;
    }
}
