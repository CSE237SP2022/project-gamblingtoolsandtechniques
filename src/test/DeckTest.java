package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import main.Card;
import main.Deck;

class DeckTest {

	@Test
	void testConstructor() {
		Deck d = new Deck();
		Deck e = new Deck(2);
		assertAll(
				() -> assertEquals(d.getSize(), 52),
				() -> assertEquals(e.getSize(), 104)
		);
		
	}
	
	@Test
	void testDealSize() {
		Deck d = new Deck();
		assertAll(
				() -> assertEquals(d.getSize(), 52),
				() -> assertInstanceOf(Card.class, d.deal()),
				() -> assertEquals(d.getSize(), 51)
		);
	}
	
	@Test
	void testDealCard() {
		Deck d = new Deck(1, false);
		Card card = new Card(3, 14);
		Card cardFromDeck = d.deal();
		assertEquals(card.compareTo(cardFromDeck), 0);
	}
	
	@Test
	void testPeekCard() {
		Deck d = new Deck(1, false);
		Card card = new Card(3, 14);
		Card cardFromDeck = d.peekNext();
		assertEquals(card.compareTo(cardFromDeck), 0);
	}
	
	@Test
	void testAddSingleCard() {
		Deck d = new Deck();
		Card cardToAddCard = new Card(0, 3);
		d.add(cardToAddCard);
		Card topCard = d.peekNext();
		assertAll(
				() -> assertEquals(d.getSize(), 53),
				() -> assertEquals(cardToAddCard.compareTo(topCard), 0)
		);
	}
	
	@Test
	void testAddCardStack() {
		Deck d = new Deck();
		Stack<Card> s = new Stack<Card>();
		s.push(new Card(1, 3));
		s.push(new Card(1, 4));
		s.push(new Card(0, 5));
		d.add(s);
		assertAll(
				() -> assertEquals(d.getSize(), 55),
				() -> assertEquals(d.peekNext().compareTo(new Card(1, 3)), 0)
		);
		
	}
	
	@Test
	void testAddCardList() {
		Deck d = new Deck();
		List<Card> l = new ArrayList<Card>();
		Card a = new Card(1, 3);
		Card b = new Card(2, 4);
		l.add(a);
		l.add(b);
		d.add(l);
		assertEquals(d.getSize(), 54);
	}
	
	@Test
	void testToString() {
		Deck d = new Deck(0);
		String expecString = "Number of cards: 0\n";
		assertEquals(d.toString(), expecString);
	}

}
