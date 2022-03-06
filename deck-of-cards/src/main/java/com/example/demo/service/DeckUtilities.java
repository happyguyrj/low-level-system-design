package com.example.demo.service;

import com.example.demo.domain.Card;
import com.example.demo.domain.Deck;

import java.util.List;

public interface DeckUtilities {

    void sortDeck(List<Card> cards);

    void shuffleDeck(Deck deck);

}
