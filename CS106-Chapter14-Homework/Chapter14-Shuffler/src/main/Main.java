package main;
import cards.*;

import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Card aCard = new Card(0,0);
		Queue<ICard> deck = aCard.createDeck();

		System.out.println(deck.toString());
		
//		// Reverse Cards.
//		Shuffler.reverse(deck);
//		System.out.println(deck.toString());
//		
//		// Riffle the cards.
//		Shuffler.riffle(deck);
//		System.out.println(deck.toString());
//		
//		// Strip the cards.
//		Shuffler.strip(deck);
//		System.out.println(deck.toString());
//		
//		// Pile the cards.
//		Shuffler.piles(deck,4);
//		System.out.println(deck.toString());
//		
//		// Diaconis the cards.
//		Shuffler.diaconis(deck);
//		System.out.println(deck.toString());
//		
//		// Cut the cards.
//		Shuffler.cut(deck);
//		System.out.println(deck.toString());
//		
//		// Mongean the cards.
//		Shuffler.mongean(deck);
//		System.out.println(deck.toString());
//
//		// Hindu the cards.
//		Shuffler.hindu(deck);
//		System.out.println(deck.toString());
	}

}
