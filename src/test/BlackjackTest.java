package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

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
		blackjack.addPlayerCard();
		assertTrue(blackjack.getPlayerTotal() > 0);
	}
	
	@Test
	void testSetup() {
		Scanner scan = new Scanner(System.in);
		Blackjack blackjack = new Blackjack(50);
		blackjack.setup(scan);
		//assertEquals();
	}
	
	@Test
	void testPlayRounds() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			blackjack.play(scan);
		}
		int numRounds = 10;
		int rounds = blackjack.getRounds();
		assertEquals(numRounds,rounds);
	}
	
	@Test
	void testCreditsAfterPlay() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		int mult = 0;
		int creditsAfter = 0;
		for (int i = 0; i < 10; i++) {
			int result = blackjack.round(scan);
			if (result == 1) {
				mult = 1;
			} else if (result == 2) {
				mult = -1;
			}
			int wager = blackjack.getWager();
			creditsAfter = 50 + mult*wager;
		}
		int credits = blackjack.getCredits();
		assertEquals(creditsAfter, credits);
	}
	
	@Test
	void testWinState1A() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(21);
		blackjack.setDealerTotal(3);
		int winState = blackjack.round(scan);
		assertEquals(winState, 1);
	}
	
	@Test
	void testWinState1B() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(17);
		blackjack.setDealerTotal(25);
		int winState = blackjack.round(scan);
		assertEquals(winState, 1);
	}
	
	@Test
	void testWinState2A() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(24);
		blackjack.setDealerTotal(4);
		int winState = blackjack.round(scan);
		assertEquals(winState, 2);
	}
	
	@Test
	void testWinState2B() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(14);
		blackjack.setDealerTotal(16);
		int winState = blackjack.round(scan);
		assertEquals(winState, 2);
	}
	
	@Test
	void testWinState2C() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(17);
		blackjack.setDealerTotal(17);
		int winState = blackjack.round(scan);
		assertEquals(winState, 0);
	}
	
}
