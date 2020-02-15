package com.skilldistillery.blackjack.hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackHand []");
		return builder.toString();
	}

	@Override
	public int getHandValue() {

		return 0;
	}
	
	public boolean isBust() {
		return false;
	}
	
	public boolean isBlackjack() {
		return false;
	}

}
