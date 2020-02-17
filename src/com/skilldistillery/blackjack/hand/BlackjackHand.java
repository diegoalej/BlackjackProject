package com.skilldistillery.blackjack.hand;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
//		List<Card> cards;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.getCards().size(); i++) {
			builder.append(this.getCards().get(i));
			if ((this.getCards().size() - 1) > i) {
				builder.append(" and ");
			}
			else {
			builder.append(" ");
			}
		}
		builder.append("\nfor a total of ");
		builder.append(getHandValue());
		return builder.toString();
	}

	@Override
	public int getHandValue() {
		int cardTotalValue = 0;
		for (int i = 0; i < this.getCards().size(); i++) {
			cardTotalValue += this.getCards().get(i).getRank().getValue();
		}
		if (cardTotalValue > 21) {// Conditional for Ace as 1 or 11
			for (Card card : (this.getCards())) {
				if(card.getRank().getValue() == 11) {
//					System.out.println("Ace is low on this hand");
					cardTotalValue -= 10;
				}
			}
		}	
		return cardTotalValue;
	}
	//Method tests different cases for all outcomes of hand
	public boolean isBust() {
		int totalHandValue = this.getHandValue();
		if(totalHandValue <= 21) {
			return false;			
		}
		else if (totalHandValue > 21){
			System.out.println("Busted with a total of " + totalHandValue);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isBlackjack() {
		int cardTotalValue = this.getHandValue();
		if(cardTotalValue == 21) {
			System.out.println("Blackjack!");
			return true;
		}
		else {
			return false;
		}
	}

}
