package com.example.demo.domain;

public class Card {

    CardsEnum name;
    SuitesEnum suite;

    public Card(CardsEnum name, SuitesEnum suite) {
        this.name = name;
        this.suite = suite;
    }

    @Override
    public String toString() {
        return suite.toString() + name.toString();
    }
}
