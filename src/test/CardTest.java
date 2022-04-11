package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Card;

class CardTest {
	
	@Test
	void testConstructorValid() {
		Card a = new Card(1, 2);
		// if there's no error, construction passed
		return;
	}

	@Test
	void testConstructorInvalid() {
		try {
			Card a = new Card(1, 1);
		} 
		catch(IllegalArgumentException e) {
			return;
		}
		
	}
	
	@Test
	void testAccessors() {
		Card a = new Card(1, 2);
		Card b = new Card(3, 4);
		Card c = new Card(2, 14);
		assertAll(
				() -> assertEquals(a.suit(), 1),
				() -> assertEquals(a.rank(), 2),
				() -> assertEquals(b.suit(), 3),
				() -> assertEquals(b.rank(), 4),
				() -> assertEquals(c.suit(), 2),
				() -> assertEquals(c.rank(), 14)
		);
	}
	
	@Test
	void testStrings() {
		Card a = new Card(1, 2);
		assertAll(
				() -> assertEquals(a.suitStr(), "C"),
				() -> assertEquals(a.rankStr(), "2"),
				() -> assertEquals(a.toString(), "2C")
		);
	}
	
	@Test
	void testComparator() {
		Card base = new Card(1, 5);
		Card greater = new Card(3, 10);
		Card lesser = new Card(2, 2);
		Card equal = new Card(0, 5);
		assertAll(
				() -> assertEquals(base.compareTo(greater), -1),
				() -> assertEquals(base.compareTo(lesser), 1),
				() -> assertEquals(base.compareTo(equal), 0)
		);
	}

}