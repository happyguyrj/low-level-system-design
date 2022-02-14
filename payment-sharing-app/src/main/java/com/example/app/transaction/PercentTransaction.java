package com.example.app.transaction;

import com.example.app.domain.User;
import com.example.app.split.ExactSplit;
import com.example.app.split.PercentSplit;
import com.example.app.split.Split;

import java.util.List;

public class PercentTransaction extends Transaction {

    public PercentTransaction(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        double totalPercent = 100;
        double sumPercent = 0;

        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
            PercentSplit percentSplit = (PercentSplit) split;
            sumPercent += percentSplit.getPercent();
        }

        return totalPercent == sumPercent;
    }
}
