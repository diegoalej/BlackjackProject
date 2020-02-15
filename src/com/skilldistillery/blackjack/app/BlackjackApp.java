package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Deck;

public class BlackjackApp {

	public static void main(String[] args) {
		Deck th = new Deck();
		Scanner kb = new Scanner(System.in);
		while (th.checkDeckSize() != 0) {
			System.out.print("How many cards would you want? ");
			int choice;
			try {
				choice = kb.nextInt();
				if (choice <= th.checkDeckSize()) {
					for (int i = 0; i < choice; i++) {
						System.out.println(th.dealCard());
					}
				} else {
					System.out.println("You cannot ask for more than 52 cards");
				}
			} catch (Exception e) {
				System.out.println("Incorrect input, try again");
			}

		}
		System.out.println("You ran out of cards!");

		kb.close();
	}

}
