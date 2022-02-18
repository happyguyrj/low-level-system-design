package com.example.demo;

import com.example.demo.domain.Deck;
import com.example.demo.service.DeckUtilities;
import com.example.demo.service.DeckUtilitiesImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class DemoApplication {

	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck);

		deck.shuffle();
		System.out.println(deck);

		deck.sort();
		System.out.println(deck);

	}

}
