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
			System.out.println("Dealing first card to player upside down");
			player.getHand().addCard(deck.dealCard());
			System.out.println("You take a peek and see it is a " + player.getHand().getCards().get(0));
			System.out.println("Dealing first card to dealer upside down");
			this.getHand().addCard(deck.dealCard());
			
			System.out.println("Dealing second card to player right-side up");
			player.getHand().addCard(deck.dealCard());
			System.out.println("You see it is a " + player.getHand().getCards().get(1));
			
			System.out.println("Dealing second card to dealer right-side up");
			this.getHand().addCard(deck.dealCard());
			System.out.println("You see it is a " + this.getHand().getCards().get(1));
			
			System.out.println(player.getClass().getSimpleName() + "you have:\n" + player.getHand());
		}
		
		public void dealAdditionalCard(Player player) {
			System.out.println("Dealing additional card to " + player.getClass().getSimpleName() );
			player.getHand().addCard(deck.dealCard());
			System.out.println("You see it is a " + player.getHand().getCards().get((player.getHand().getCards().size()-1)));
			System.out.println(player.getClass().getSimpleName() + " you now have:\n" + player.getHand());				
			
		}
		
}
