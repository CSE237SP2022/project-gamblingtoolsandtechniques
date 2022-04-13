package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Slots;

class SlotsTest {

	@Test
	void testGetCredits() {
		Slots slots = new Slots();
		int credits = slots.getCredits();
		
		assertEquals(50, credits);
	}
	
	@Test
	void testGetNumPlays() {
		Slots slots = new Slots();
		int plays = slots.getNumPlays();
		
		assertEquals(0, plays);
	}
	
	@Test
	void testGetNumWins() {
		Slots slots = new Slots();
		int wins = slots.getNumWins();
		
		assertEquals(0, wins);
	}
	
	@Test
	void testHasEnoughCredits() {
		Slots slots = new Slots();
		
		boolean enoughCredits = slots.hasEnoughCredits();
		
		assertEquals(true, enoughCredits);
	}
	
	@Test
	void testGenerateNumbers() {
		Slots slots = new Slots();
		
		int[] numbers = slots.generateNumbers();
		
		assertEquals(3, numbers.length);
		assertEquals(true, (numbers[0] >= 0 && numbers[0] <= 4));
		assertEquals(true, (numbers[1] >= 0 && numbers[0] <= 4));
		assertEquals(true, (numbers[2] >= 0 && numbers[0] <= 4));
	}
	
	@Test
	void testInitialStatsUpdate() {
		Slots slots = new Slots();
		
		slots.initialStatsUpdate();
		
		assertEquals(49, slots.getCredits());
		assertEquals(1, slots.getNumPlays());
	}
	
	@Test
	void testNonNumberInputProtocol() {
		Scanner scan = new Scanner(System.in);
		Slots slots = new Slots();
		
		System.out.println("enter a string");
		int number = slots.nonNumberInputProtocol(scan);
		assertEquals(0, number);
	}
	
	@Test
	void testCheckIfWin() {
		int[] winningHand = {4, 4, 4};
		int[] losingHand = {1, 2, 2};
		
		boolean areEqual = Slots.checkIfWin(winningHand);
		boolean arentEqual = Slots.checkIfWin(losingHand);
		
		assertEquals(true, areEqual);
		assertEquals(false, arentEqual);
	}
	
	@Test
	void testWinProtocol() {
		Slots slots = new Slots();
		
		slots.winProtocol();
		
		assertEquals(60, slots.getCredits());
		assertEquals(1, slots.getNumWins());
		
	}
	
	@Test
	void testNumCreditsAfterGameplay() {
		Slots slots = new Slots();
		for (int i=0; i<10; i++) {
			slots.play();
		}
		int wins = slots.getNumWins();
		int credits = slots.getCredits();
		int expectedCredits = 50 - 10 + (wins * 10);
		
		assertEquals(expectedCredits, credits);
	}

}

/*
 * 1. initiate play
 * 	a. user input initiating play
 * 	b. check enough credits
 * 		i. if so, subtract one, add one to plays and play
 * 		ii. if not, print message
 * 2. generate 3 random numbers and print them
 * 3. check if these 3 are equal
 * 	a. if so: add points (10?), print message
 * 	b. if not, print message
 * */