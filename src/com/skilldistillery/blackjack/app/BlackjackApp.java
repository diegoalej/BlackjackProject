package com.skilldistillery.blackjack.app;
import java.util.Scanner;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.players.BlackjackDealer;
import com.skilldistillery.blackjack.players.BlackjackPlayer;

public class BlackjackApp {
	private static BlackjackApp app = new BlackjackApp();
	private static Scanner kb = new Scanner(System.in);
	

	public static void main(String[] args) {
		app.launch();
		
		
	}

	private void launch() {
		Deck deck = new Deck();
		BlackjackDealer dealer = new BlackjackDealer(deck);
		BlackjackPlayer player = new BlackjackPlayer();
		System.out.println("Welcome to Blackjack App ");
		System.out.println("Let's play a hand ");
		dealer.dealInitialHand(player);
		System.out.println(player.getHand());
		System.out.println(dealer.getHand());
		
		
		
	}

}
