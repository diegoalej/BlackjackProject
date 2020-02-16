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
		dealersTurn(dealer);
		determineWinner(player, dealer);
	}

	private void playersTurn(BlackjackPlayer player, BlackjackDealer dealer) {
		while (!player.getHand().isBust()) {
			System.out.print("Would you like to \n1) hit  \n2) stay\n>  ");
			int choice = kb.nextInt();
			if (choice == 1) {
				dealer.dealAdditionalCard(player);
				if (player.getHand().isBust()) {
					break;
				}
			} else if (choice == 2) {
				System.out.println(
						"You choose to stay with a total of " + player.getHand().getHandValue() + ", dealer's turn");
				break;
			}
		}
	}

	private void dealersTurn(BlackjackDealer dealer) {
		System.out.println(dealer.getClass().getSimpleName() + " has a " + dealer.getHand());
		while (!dealer.getHand().isBust()) {
			if (dealer.getHand().getHandValue() <= 17) {
				dealer.dealAdditionalCard(dealer);
				if (dealer.getHand().isBust()) {
					break;
				}
			} else
				System.out.println("Dealer ends turn with a total of " + dealer.getHand().getHandValue());
			break;
		}
	}

	private void determineWinner(BlackjackPlayer player, BlackjackDealer dealer) {
		if (player.getHand().getHandValue() > 21 && dealer.getHand().getHandValue() <= 21) {
			System.out.println("House wins!");
		} else if (dealer.getHand().getHandValue() > 21 && player.getHand().getHandValue() <= 21) {
			System.out.println("You beat the house!");
		} else if (player.getHand().getHandValue() <= dealer.getHand().getHandValue()) {
			System.out.println("House wins!");
		} else if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("You bear the house! ");
		}

	}

}
