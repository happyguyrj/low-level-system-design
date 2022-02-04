package com.example.app.comparatorImpl;

import com.example.app.Comparator;
import com.example.app.domain.User;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User a, User b) {
        return a.getAge() - b.getAge();
    }
}
