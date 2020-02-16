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
		mainMenu(player, dealer);
		
	}

	private void mainMenu(BlackjackPlayer player, BlackjackDealer dealer) {
		System.out.println("Welcome to Blackjack App ");
		int userChoice = 3;
			while(userChoice != 2) {
				System.out.println("Enter an integer to select from the menu below: ");
				System.out.println("1. Play a Blackjack hand ");
				System.out.print("2. Exit\n>  ");
			try {
				userChoice = kb.nextInt();
				if (userChoice == 1) {
					while(userChoice != 2) {
						dealer.dealInitialHand(player);
						playersTurn(player, dealer);
						dealersTurn(dealer);
						determineWinner(player, dealer);
						System.out.println("there are " + dealer.getDeck().checkDeckSize() + " cards left in the deck" );
						dealer.getHand().clear();
						player.getHand().clear();
						System.out.println("Would you like to play again?");
						System.out.println("1. Yes! ");
						System.out.print("2. No\n>  ");
						try {
							userChoice = kb.nextInt();
							if (userChoice == 1) {
								continue;
							}
							else if (userChoice == 2) {
								System.out.println("Goodbye!");
								break;
							}
							else {
								System.out.println("Your choice was outside menu bounds, back to main menu");
								break;
							}
						} catch (Exception e) {
							System.out.println("You did not enter the integers 1 or 2, back to main menu");
							kb.nextLine();
							break;
						}						
					}
				}
				else if (userChoice == 2) {
					System.out.println("Goodbye!");
					break;
				}
				else {
					System.out.println("Your choice was outside menu bounds, try again");
					continue;
				}
			} catch (Exception e) {
				System.out.println("You did not enter the integers 1 or 2, try again");
				kb.nextLine();
				continue;
			}
		}
	}

	private void playersTurn(BlackjackPlayer player, BlackjackDealer dealer) {
		if(player.getHand().isBlackjack()) {
			System.out.println("We do not allow hits on 21, but congratulations on your Blackjack!");
		}
		else {
			while (!player.getHand().isBust()) {
				System.out.print("Would you like to: \n1) Hit  \n2) Stay\n>  ");
				try {
					int choice = kb.nextInt();
					if (choice == 1) {
						dealer.dealAdditionalCard(player);
						if (player.getHand().isBust()) {
							break;
						}
						else if(player.getHand().isBlackjack()) {
							System.out.println("We do not allow hits on 21, but congratulations on your Blackjack!");
							break;
						}
					} else if (choice == 2) {
						System.out.println(
								"You choose to stay with a total of " + player.getHand().getHandValue() + ", dealer's turn");
						break;
					}
					else {
						System.out.println("Choice outside of menu bounds, try again");
						continue;
					}
				} catch (Exception e) {
					System.out.println("Incorrect input, try again");
					kb.nextLine();
					continue;
				}
			}
		}
	}

	private void dealersTurn(BlackjackDealer dealer) {
		System.out.println(dealer.getClass().getSimpleName() + " has a " + dealer.getHand());
		while (!dealer.getHand().isBust()) {
			if (dealer.getHand().getHandValue() < 17) {
				dealer.dealAdditionalCard(dealer);
				if (dealer.getHand().isBust()) {
					break;
				}
				continue;
			} else
				System.out.println("Dealer ends turn with a total of " + dealer.getHand().getHandValue());
			break;
		}
	}

	private void determineWinner(BlackjackPlayer player, BlackjackDealer dealer) {
		if (player.getHand().getHandValue() > 21) {
			System.out.println("House wins!");
		} else if (dealer.getHand().getHandValue() > 21 && player.getHand().getHandValue() <= 21) {
			System.out.println("You beat the house!");
		} else if (player.getHand().getHandValue() <= dealer.getHand().getHandValue()) {
			System.out.println("House wins!");
		} else if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("You beat the house! ");
		}

	}

}
