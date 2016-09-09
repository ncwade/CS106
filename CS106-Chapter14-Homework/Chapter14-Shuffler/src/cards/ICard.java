package cards;

import java.util.Queue;

public interface ICard {
	public final int JACK = 11;
	public final int QUEEN = 12;
	public final int KING = 13;
	public final int ACE = 14;
	public final int JOKER_RANK = 15;

	public final int CLUBS = 0;
	public final int DIAMONDS = 1;
	public final int HEARTS = 2;
	public final int SPADES = 3;
	public final int JOKER_SUIT = 4;
		
	// return a rank value, uses constants for royalty
	public int Rank();
	public int Suit();
	
	public Queue<ICard> createDeck();
}
