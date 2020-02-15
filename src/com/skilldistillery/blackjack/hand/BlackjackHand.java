package com.skilldistillery.blackjack.hand;


public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
//		List<Card> cards;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("You have a ");
		for (int i = 0; i < this.getCards().size(); i++) {
			builder.append(this.getCards().get(i));
			builder.append(" ");
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
		return false;
	}
	
	public boolean isBlackjack() {
		return false;
	}

}
