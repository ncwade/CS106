package cards;

import java.util.LinkedList;
import java.util.Queue;

public class Card implements ICard {
	private int rank;
	private int suit;
	

	public Card(int suit, int rank){
		this.rank = rank;
		this.suit = suit;
	}
	
	@Override
	public int Rank() {
		return rank;
	}

	@Override
	public int Suit() {
		return suit;
	}

	@Override
	public Queue<ICard> createDeck() {
		
		Queue<ICard> deck = new LinkedList<ICard>();
		
		for(int suit = 0; suit < 4; suit++)
			for(int rank = 2; rank < 15; rank++)
				deck.add(new Card(suit, rank));

		deck.add(new Card(JOKER_SUIT, JOKER_RANK));
		deck.add(new Card(JOKER_SUIT, JOKER_RANK));

		return deck;
	}
	// ACE of HEARTS
	// HA, HK, HQ, ... H2
	// AC, KC, QC, ... 2C

	@Override
	public String toString(){

	    StringBuilder card = new StringBuilder();
	//	String card = "";

		switch(rank){
		case JACK:
			card.append("J");
			break;
		case QUEEN:
			card.append("Q");
			break;
		case KING:
			card.append("K");
			break;
		case ACE:
			card.append("A");
			break;
		case JOKER_RANK:
			card.append("J");
			break;
		default:
			card.append(Integer.toString(rank));
		}
		
		switch(suit){
		  case SPADES:
              card.append("S"); //(char)'\u2660');
              break;
          case DIAMONDS:
              card.append("D"); //(char)'\u2666');
              break;
          case CLUBS:
              card.append("C"); //(char)'\u2663');
              break;
          case HEARTS:
              card.append("H"); //(char)'\u2764');
              break;
          case JOKER_SUIT:
              card.append("J"); //(char)'\u2764');
              break;
		}
		
	//	card = "(" + rank +  ", " + suit + ")";
		return card.toString();
	}
}