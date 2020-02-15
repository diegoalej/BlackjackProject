package com.skilldistillery.blackjack.hand;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.players.Player;

public abstract class Hand {
	private List<Card> cards;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [cards=");
		builder.append(cards);
		builder.append("]");
		return builder.toString();
	}

	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards = new ArrayList<Card>();
	}
	
	public List<Card> getCards(){
		return cards;
	}


	public abstract int getHandValue();
}
