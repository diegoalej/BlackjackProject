package com.skilldistillery.blackjack.cards;

public class Card {

	private Suit suit;
	private Rank rank;
	
	
	public Card(Suit suit, Rank rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(rank.getValue() == 11) {
			builder.append("Ace");
		}		
		else if(rank == Rank.KING) {
			builder.append("King");
		}		
		else if(rank == Rank.QUEEN) {
			builder.append("Queen");
		}		
		else if(rank == Rank.JACK) {
			builder.append("Jack");
		}		
		else {
			builder.append(rank.getValue());			
		}
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
}
