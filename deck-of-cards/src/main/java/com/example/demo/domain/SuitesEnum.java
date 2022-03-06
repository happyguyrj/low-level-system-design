package com.example.demo.domain;

public enum SuitesEnum {
    CLUB (1),
    SPADES (2),
    HEART (3),
    DIAMOND (4);

    int value;

    SuitesEnum(int value) {
        this.value = value;
    }
}


