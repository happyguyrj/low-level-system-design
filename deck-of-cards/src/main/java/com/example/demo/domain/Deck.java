package com.example.demo.domain;

import java.util.*;

public class Deck {

    List<Card> cards;

    public Deck() {
        List<Card> cards = new ArrayList<>();
        for( SuitesEnum suite : SuitesEnum.values()) {
            for( CardsEnum cardsEnum: CardsEnum.values()) {
                cards.add(new Card(cardsEnum, suite));
            }
        }
        this.cards = cards;
    }

    public void sort() {
        List<Card> cardsInDeck = new ArrayList<>();
        for (Card card : this.cards) {
            cardsInDeck.add((card.suite.value-1)*13 + (card.name.value-1),card);
        }
        this.cards = cardsInDeck;
    }


    public void shuffle() {
        for (int j=0; j< SuitesEnum.values().length*CardsEnum.values().length; j++) {
            swapCards(j, (int) Math.round(Math.random()*52));
        }
    }

    private void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.remove(i);
        cards.add(i, cards.get(j));
        cards.remove(j);
        cards.add(j, temp);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
