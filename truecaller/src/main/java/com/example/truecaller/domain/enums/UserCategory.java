package com.example.truecaller.domain.enums;

public enum UserCategory {
    SERVICES(0),
    SALES(1),
    BANK(2);

    private int id;

    UserCategory(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
