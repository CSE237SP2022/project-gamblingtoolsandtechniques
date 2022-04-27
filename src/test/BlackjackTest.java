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
	void testSetTotals() {
		Blackjack blackjack = new Blackjack(50);
		int total = 21;
		blackjack.setDealerTotal(total);
		blackjack.setPlayerTotal(total);
		assertTrue(blackjack.getPlayerTotal() == total);
		assertTrue(blackjack.getDealerTotal() == total);
	}
	
	@Test
	void testSetCard() {
		Blackjack blackjack = new Blackjack(50);
		int card = 5;
		blackjack.setCard(card);
		assertTrue(blackjack.getCard() == 5);
	}
	
	@Test
	void testSetupHelper() {
		Scanner scan = new Scanner(System.in);
		Blackjack blackjack = new Blackjack(50);
		blackjack.setup(scan);
		//assertEquals(); //test scans
	}
	
	@Test
	void testSetup() {
		Scanner scan = new Scanner(System.in);
		Blackjack blackjack = new Blackjack(50);
		blackjack.setup(scan);
		//assertEquals(); //test scans
	}
	
	@Test
	void testWinProtocol() {
		Blackjack blackjack = new Blackjack(50);
		int wager = blackjack.getWager();
		int credits = blackjack.getCredits();
		int wins = blackjack.getWins();
		blackjack.winProtocol();
		assertTrue(blackjack.getCredits() == credits + wager);
		assertTrue(blackjack.getWins() == wins + 1);
	}
	
	@Test
	void testLoseProtocol() {
		Blackjack blackjack = new Blackjack(50);
		int wager = blackjack.getWager();
		int credits = blackjack.getCredits();
		blackjack.loseProtocol();
		assertTrue(blackjack.getCredits() == credits - wager);
	}
	
	@Test
	void testPlayCallerHelper() {
		Blackjack blackjack = new Blackjack(50);
		//how do we test a method that does pretty much nothing
	}
	
	@Test
	void testPlayCaller() {
		Blackjack blackjack = new Blackjack(50);
		//test scans
	}
	
	@Test
	void testSetWager() {
		Blackjack blackjack = new Blackjack(50);
		//test scans
	}
	
	@Test
	void testWinState1A() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setPlayerTotal(21);
		blackjack.setDealerTotal(3);
		blackjack.roundWinState();
		int winState = blackjack.getWinState();
		assertEquals(winState, 1);
	}
	
	@Test
	void testWinState1B() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setPlayerTotal(17);
		blackjack.setDealerTotal(25);
		blackjack.roundWinState();
		int winState = blackjack.getWinState();
		assertEquals(winState, 1);
	}
	
	@Test
	void testWinState2A() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setPlayerTotal(24);
		blackjack.setDealerTotal(4);
		blackjack.roundWinState();
		int winState = blackjack.getWinState();
		assertEquals(winState, 2);
	}
	
	@Test
	void testWinState2B() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setPlayerTotal(14);
		blackjack.setDealerTotal(16);
		blackjack.roundWinState();
		int winState = blackjack.getWinState();
		assertEquals(winState, 2);
	}
	
	@Test
	void testWinState2C() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setPlayerTotal(17);
		blackjack.setDealerTotal(17);
		blackjack.roundWinState();
		int winState = blackjack.getWinState();
		assertEquals(winState, 0);
	}
	
	@Test
	void testPlayDealerUnder() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setDealerTotal(1);
		blackjack.playDealer();
		assertTrue(blackjack.getDealerTotal() > 1);
	}
	
	@Test
	void testPlayDealerOver() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setDealerTotal(20);
		blackjack.playDealer();
		assertTrue(blackjack.getDealerTotal() == 20);
	}
	
	@Test
	void testGamePlayHelperHit() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setPlayerTotal(0);
		boolean gameOver = blackjack.gamePlayHelper("y");
		assertTrue(blackjack.getPlayerTotal() > 0);
		assertEquals(false, gameOver);
	}
	
	@Test
	void testGamePlayHelperStay() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setDealerTotal(1);
		boolean gameOver = blackjack.gamePlayHelper("n");
		assertTrue(blackjack.getDealerTotal() >= 17);
		assertEquals(true, gameOver);
	}
	
	@Test
	void testGamePlayBust() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(22);
		boolean gameOver = blackjack.gamePlay(scan);
		assertEquals(true, gameOver);
	}
	
	@Test
	void testGamePlayChoice() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setPlayerTotal(1);
		blackjack.setDealerTotal(1);
		//test scans
		boolean gameOver = blackjack.gamePlay(scan);
		assertEquals(blackjack.gamePlayHelper("y"), gameOver);
	}
	
	@Test
	void testPlayRounds() {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			blackjack.playCaller(scan);
		}
		int numRounds = 10;
		int rounds = blackjack.getRounds();
		assertEquals(numRounds,rounds);
	}
	
	@Test
	void testRoundSetup() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.roundSetup();
		assertTrue(blackjack.getDealerTotal() > 2);
		assertTrue(blackjack.getPlayerTotal() > 2);
	}
	
	@Test
	void testAceChangeLow() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.aceChange(11);
		assertTrue(blackjack.getCard() == 1);
	}
	
	@Test
	void testAceChangeHigh() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.aceChange(10);
		assertTrue(blackjack.getCard() == 11);
	}
	
	@Test
	void testCardNamerFace() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setCard(5);
		assertTrue(blackjack.cardNamer(0).equals("ace"));
	}
	
	@Test
	void testCardNamerAce() {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setCard(11);
		assertTrue(blackjack.cardNamer(0).equals("ace"));
	}
	
	@Test
	void testCardNamerNumber() {
		Blackjack blackjack = new Blackjack(50);
		int card = 5;
		blackjack.setCard(card);
		assertTrue(blackjack.cardNamer(1).equals("" + card));
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
	void testHasEnoughCredits() {
		Blackjack blackjack = new Blackjack(50);
		int potentialWager = 25;
		boolean enoughCredits = blackjack.hasEnoughCredits(potentialWager);
		assertEquals(true, enoughCredits);
	}
}
