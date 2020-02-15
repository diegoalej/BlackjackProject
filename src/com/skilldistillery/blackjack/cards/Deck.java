package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Deck {
private List<Card> deck = new ArrayList<>();
	
	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] values = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : values) {
				deck.add(new Card(suit, rank ));
			}
		}
		shuffle(deck);
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	public Card dealCard() {
		Card o = deck.get(0);
		deck.remove(o);
		return o;
	}
	private void shuffle(List<Card> deck) {
		Collections.shuffle(deck);
	}

}
