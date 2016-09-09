package shuffler;

import java.util.*;
import cards.ICard;

public class Shuffler {
	public static void reverse(Queue<ICard> deck){
		Stack<ICard> buffer = new Stack<ICard>();
		
		while(!deck.isEmpty())
			buffer.push(deck.remove());
		
		while(!buffer.isEmpty())
			deck.add(buffer.pop());
	}
	
	public static void FisherYates(Queue<ICard> deck){
		for(int i = deck.size() - 1; i > 0; i--){
			int swap = (int) (Math.random() * i);
			
			FYSwap(deck, swap, i);		
		}
	}
	
	private static void FYSwap(Queue<ICard> deck, int first, int second){
		ICard store;					// create store
			
		for(int i = 0; i < first; i++)	// spin to first
			deck.add(deck.remove()); 	// spin
		
		store = deck.remove();			// remove element and place in store
		
		deck.add(null);					// insert null
		
		
		for(int i = 0; i < second - first - 1; i++) // spin to second
			deck.add(deck.remove()); // spin
		
		// add stored element
		deck.add(store);
		
		// remove element and place in store 
		store = deck.remove();
		
		// spin to null
		while(deck.peek() != null)
			deck.add(deck.remove()); // spin
		
		// remove null
		deck.remove();
		
		// add stored element
		deck.add(store);
		
		// reset deck
		for(int i = 0; i < deck.size() - first - 1; i++)
			deck.add(deck.remove()); // spin
	}

	public static void riffle(Queue<ICard> deck) {
		Queue<ICard> half1 = new LinkedList<ICard>();
		Queue<ICard> half2 = new LinkedList<ICard>();
		int size = deck.size();

		for(int i = 0; i < (size / 2); i++) {
			half1.add(deck.remove());
		}

		for(int i = 0; i < (size / 2); i++) {
			half2.add(deck.remove());
		}

		for(int i = 0; i < (size / 2); i++) {
			deck.add(half1.remove());
			deck.add(half2.remove());
		}
	}

	public static void strip(Queue<ICard> deck) {
		Queue<ICard> buffer1 = new LinkedList<ICard>();
		Queue<ICard> buffer2 = new LinkedList<ICard>();
		Random rand = new Random();
		int randNum = rand.nextInt(deck.size()-1) + 1;
		
		// Loop half way through the deck.
		for(int i = 0; i < (deck.size() / 2); i++) {
			deck.add(deck.remove());
		}
		
		// Add our random randNum of cards to the bottom of the new deck.
		for(int i = 0; i < (randNum); i++) {
			buffer1.add(deck.remove());
		}
		
		randNum = rand.nextInt(deck.size()) + 1;
		// Add our random number of cards to the bottom of the new deck.
		for(int i = 0; i < (randNum); i++) {
			buffer2.add(deck.remove());
		}

		buffer1.addAll(deck);
		buffer1.addAll(buffer2);
		deck.clear();
		deck.addAll(buffer1);
	}

	public static void piles(Queue<ICard> deck, int numPiles){
		@SuppressWarnings("unchecked")
		LinkedList<ICard>[] piles = new LinkedList[numPiles];
		int cardsPerPile = deck.size()/numPiles;
		
		// Init
		for(int j = 0; j < numPiles; j++) {
			piles[j] = new LinkedList<ICard>();
		}		
		// Break into piles
		for(int j = 0; j < numPiles; j++) {
			for(int i = 0; i < cardsPerPile; i++) {
				piles[j].add(deck.remove());
			}
		}
		// Put back into deck.
		for(int j = 0; j < numPiles; j++) {
			for(int i = 0; i < cardsPerPile; i++) {
				deck.add(piles[j].remove());
			}
		}
		
	}

	public static void diaconis(Queue<ICard> deck) {
		for(int i = 0; i < 7; i++) {
			riffle(deck);
			strip(deck);
		}
	}
	
	public static void cut(Queue<ICard> deck) {
		for(int i = 0; i < (deck.size() / 2); i++) {
			deck.add(deck.remove());
		}
	}
	
	public static void mongean(Queue<ICard> deck) {
		Deque<ICard> buffer = new LinkedList<ICard>();
		int size = deck.size();
		for(int i = 0; i < size; i++) {
			if(i % 2 == 0) {
				buffer.addFirst(deck.remove());
			} else {
				buffer.addLast(deck.remove());
			}
		}
		deck.clear();
		deck.addAll(buffer);
	}
	
	public static void hindu(Queue<ICard> deck) {
		Random rand = new Random();
		int randomNum = rand.nextInt((10 - 5) + 1) + 5;
		for(int i = 0; i < randomNum; i++) {
			deck.add(deck.remove());
		}
	}
}
