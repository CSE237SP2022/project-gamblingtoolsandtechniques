package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Blackjack;

class BlackjackTest {

	@Test
	void testConstructor() {
		Blackjack blackjack = new Blackjack(50);
		
		int credits = blackjack.getCredits();
		int rounds = blackjack.getRounds();
		int wins = blackjack.getWins();
		
		assertEquals(50, credits);
		assertEquals(0, rounds);
		assertEquals(0, wins);
	}
	
	@Test
	void testHasEnoughCredits() {
		Blackjack blackjack = new Blackjack(50);
		
		int potentialWager = 25;
		boolean enoughCredits = blackjack.hasEnoughCredits(potentialWager);
		
		assertEquals(true, enoughCredits);
	}
	
	@Test
	void testAddDealerCard() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.addDealerCard();
		blackjack.addDealerCard();
		assertTrue(blackjack.getDealerTotal() > 0);
		assertTrue(blackjack.getDealerShow() > 0);
		assertTrue(blackjack.getDealerTotal() > blackjack.getDealerShow());
	}
	
	@Test
	void testAddPlayerCard() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.addDealerCard();
		blackjack.addDealerCard();
		assertTrue(blackjack.getDealerTotal() > 0);
		assertTrue(blackjack.getDealerShow() > 0);
		assertTrue(blackjack.getDealerTotal() > blackjack.getDealerShow());
	}
}
