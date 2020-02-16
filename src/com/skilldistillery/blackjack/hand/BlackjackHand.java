package com.skilldistillery.blackjack.hand;


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
		builder.append("for a total of ");
		builder.append(getHandValue());
		return builder.toString();
	}

	@Override
	public int getHandValue() {
		int cardTotalValue = 0;
		for (int i = 0; i < this.getCards().size(); i++) {
			cardTotalValue += this.getCards().get(i).getRank().getValue();
		}
		return cardTotalValue;
	}
	
	public boolean isBust() {
		int cardTotalValue = 0;
		for (int i = 0; i < this.getCards().size(); i++) {
			cardTotalValue += this.getCards().get(i).getRank().getValue();
		}
		if(cardTotalValue == 21) {
			return this.isBlackjack();
		}
		else if(cardTotalValue < 21) {
			return false;			
		}
		else {
			System.out.println("You busted with a total of " + this.getHandValue());
			return true;
		}
	}
	
	public boolean isBlackjack() {
		int cardTotalValue = 0;
		for (int i = 0; i < this.getCards().size(); i++) {
			cardTotalValue += this.getCards().get(i).getRank().getValue();
		}
		if(cardTotalValue == 21) {
			System.out.println("Blackjack!");
			return true;
		}
		else {
			return false;
		}
	}

}
