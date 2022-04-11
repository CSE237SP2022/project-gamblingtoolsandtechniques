package main;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

	// in case we need a larger deck
	private int deckMultiple;
	private Stack<Card> cards;

	
	/**
	 * Returns a new deck object.
	 * 
	 * @param numDecks the number of 52-card decks to include in the new object
	 * @param shuffle specifies whether deck should be pre-shuffled
	 */
	public Deck(int numDecks, boolean shuffle) {

		deckMultiple = numDecks;
		cards = new Stack<Card>();

		// for each deck multiple
		for (int deck = 0; deck < numDecks; deck++) {
			// for each suit...
			for (int suit = 0; suit < 4; suit++) {
				// for each rank
				for (int rank = 2; rank < 15; rank++) {
					
					// push a new card to the deck
					add(new Card(suit, rank));
				}
			}
		}
		
		if (shuffle) shuffle();

	}
	
	/**
	 * Returns a new deck object. By default, includes one standard, shuffled 52-card deck
	 */
	public Deck() {
		this(1, true);
	}
	
	/**
	 * Returns a new deck object. By default, total deck is pre-shuffled
	 * 
	 * @param numDecks the number of 52-card decks to include in the new object
	 */
	public Deck(int numDecks) {
		this(numDecks, true);
	}
	
	// check current size of deck
	public int getSize() {
		return cards.size();
	}
	
	// peek at next card
	public Card peekNext() {
		return cards.peek();
	}
	
	// "deal" a card from the top of the deck
	public Card deal() {
		return cards.pop();
	}
	
	// randomize cards order
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	// add a single card to the deck
	public void add(Card c) {
		cards.push(c);
	}
	
	// add many cards to the deck from a stack
	public void add(Stack<Card> stack) {
		while (!stack.isEmpty()) {
			cards.push(stack.pop());
		}
	}
	
	// add many cards to the deck from an array or list-like object
	public void add(List<Card> list) {
		for (Card c : list) {
			cards.push(c);
		}
	}
	
	// return a string representing the deck
	// TODO: memory optimization?
	public String toString() {
		
		String out = "Number of cards: " + deckMultiple * 52 + "\n";
		int cardCounter = 0;
		
		// append each card string representation to the output
		for (Card c : cards) {
			out += c.toString() + " ";
			// start a new line after 10 cards
			if (cardCounter % 10 == 0) out += "\n";
		}
		
		return out;
		
	}

}