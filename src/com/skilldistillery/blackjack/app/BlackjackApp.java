package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.cards.*;
import com.skilldistillery.blackjack.players.*;

public class BlackjackApp {
	private static BlackjackApp app = new BlackjackApp();
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		app.launch();

	}
	//Method instantiates dealer and player and calls the main menu
	private void launch() {
		Deck deck = new Deck();
		BlackjackDealer dealer = new BlackjackDealer(deck);
		BlackjackPlayer player = new BlackjackPlayer();
		mainMenu(player, dealer);
	}
	// Method displays the main menu and begins game according to user choice
	private void mainMenu(BlackjackPlayer player, BlackjackDealer dealer) {
		System.out.println("*** Welcome to Blackjack App ***");
		int userChoice = 3;
		while (userChoice != 2) {
			System.out.println("Enter an integer to select from the menu below: ");
			System.out.println("1. Play a Blackjack hand ");
			System.out.print("2. Exit\n>  ");
			try {
				userChoice = kb.nextInt();
				if (userChoice == 1) { // The playing turn begins here
					while (userChoice != 2) {
						if(dealer.getDeck().checkDeckSize() < 10) { //Get a new deck if necessary
							Deck deck = new Deck();
							dealer = new BlackjackDealer(deck);
							System.out.println("New deck added to the game");
						}
						dealer.dealInitialHand(player); //Deal initial hand
						int playerTotal = playersTurn(player, dealer); //Player's turn 
						int dealerTotal = dealersTurn(dealer); // Dealer's turn
						determineWinner(playerTotal, dealerTotal); // Determine winner
						dealer.getHand().clear();
						player.getHand().clear();
						System.out.println("Would you like to play again?");
						System.out.println("1. Yes! ");
						System.out.print("2. No\n>  ");
						try {// Secondary menu to play again, incorrect input sends back to main
							userChoice = kb.nextInt();
							if (userChoice == 1) {
								continue;
							} else if (userChoice == 2) {
								System.out.println("Goodbye!");
								break;
							} else {
								System.out.println("Your choice was outside menu bounds, back to main menu");
								break;
							}
						} catch (Exception e) {
							System.out.println("You did not enter the integers 1 or 2, back to main menu");
							kb.nextLine();
							break;
						}
					}
				} else if (userChoice == 2) {
					System.out.println("Goodbye!");
					break;
				} else {
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
	// Method plays through player's choices
	private int playersTurn(BlackjackPlayer player, BlackjackDealer dealer) {
			while (!player.getHand().isBust()) {
				System.out.print("Would you like to: \n1) Hit  \n2) Stay\n>  ");
				try {
					int choice = kb.nextInt();
					if (choice == 1) {
						dealer.dealAdditionalCard(player);
						if (player.getHand().isBust()) {
							break;
						} else if (player.getHand().isBlackjack()) {
							System.out.println("We do not recommend hits on 21, but you are free to choose!");
							continue;
						}
					} else if (choice == 2) {
						System.out.println("You choose to stay with a total of " + player.getHand().getHandValue()
								+ ", dealer's turn \n");
						break;
					} else {
						System.out.println("Choice outside of menu bounds, try again");
						continue;
					}
				} catch (Exception e) {
					System.out.println("Incorrect input, try again");
					kb.nextLine();
					continue;
				}
			}
		return player.getHand().getHandValue();
	}
	// Method plays out dealer's turn according to preset parameter of total < 17
	private int dealersTurn(BlackjackDealer dealer) {
		int totalHandValue = dealer.getHand().getHandValue();
		System.out.println(dealer.getClass().getSimpleName() + " has a " + dealer.getHand());
		while (totalHandValue < 17) {
				dealer.dealAdditionalCard(dealer);
				if (dealer.getHand().isBust()) {
					break;
				}
				if(totalHandValue > 10) {
					if(dealer.getHand().getCards().get((dealer.getHand().getCards().size()-1)).getRank().getValue() == 11) {
						totalHandValue += 1;
						continue; 
					}					
				}
				else {
					totalHandValue += dealer.getHand().getCards().get((dealer.getHand().getCards().size()-1)).getRank().getValue();										
					continue; 
				}
		}
		if (totalHandValue >= 17) {			
			System.out.println("Dealer ends turn with a total of " + totalHandValue + "\n");
		}
		return totalHandValue;
	}

	// Method receives the player's totals and determines the winner
	private void determineWinner(int playerTotal, int dealerTotal) {
		if (playerTotal > 21) {
			System.out.println("House wins!");
		} else if (dealerTotal > 21 && playerTotal <= 21) {
			System.out.println("You beat the house!");
		} else if (playerTotal <= dealerTotal) {
			System.out.println("House wins!");
		} else if (playerTotal > dealerTotal) {
			System.out.println("You beat the house! ");
		}

	}

}
