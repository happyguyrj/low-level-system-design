package com.example.app.transaction;

import com.example.app.domain.User;
import com.example.app.split.EqualSplit;
import com.example.app.split.Split;

import java.util.List;

public class EqualTransaction extends Transaction {

    public EqualTransaction(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
