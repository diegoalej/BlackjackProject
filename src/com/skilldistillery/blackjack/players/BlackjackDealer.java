package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.Hand;

public class BlackjackDealer extends BlackjackPlayer {
		private Deck deck;
		private Hand hand;

		public BlackjackDealer(Deck deck) {
			super();
			this.deck = deck;
		}
		
		public void dealInitialHand(BlackjackPlayer player) {
			System.out.println("Dealing first card to player");
			player.getHand().addCard(deck.dealCard());
			
			System.out.println("Dealing first card to dealer");
			this.getHand().addCard(deck.dealCard());
			
			System.out.println("Dealing second card to player");
			player.getHand().addCard(deck.dealCard());
			
			System.out.println("Dealing second card to dealer");
			this.getHand().addCard(deck.dealCard());
		}
		
}
