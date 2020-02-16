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
		playersTurn(player, dealer);
		
		
		
		
	}
	
	private void playersTurn(BlackjackPlayer player, BlackjackDealer dealer) {
		if(player.getHand().isBlackjack()) {
			System.out.println("You end the turn with a total of " + player.getHand().getHandValue() + ", dealer's turn");
		}
		else {
			while (!player.getHand().isBust()) {
				System.out.print("Would you like to \n1) hit  \n2) stay\n>  ");
				int choice = kb.nextInt();
				if (choice == 1) {
					dealer.dealAdditionalCard(player);
					if(player.getHand().isBust()) {
						break;
					}
				}
				else if (choice == 2) {
					System.out.println("You choose to stay with a total of " + player.getHand().getHandValue() + ", dealer's turn");
					break;
				}				
			}
			System.out.println(dealer.getClass().getSimpleName() + " has a " +  dealer.getHand());				
		}
	}

}
