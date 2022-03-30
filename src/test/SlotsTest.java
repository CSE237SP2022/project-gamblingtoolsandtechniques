package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Slots;

class SlotsTest {

	@Test
	void testConstructor() {
		Slots slots = new Slots();
		
		int credits = slots.getCredits();
		int plays = slots.getNumPlays();
		int wins = slots.getNumWins();
		
		assertEquals(50, credits);
		assertEquals(0, plays);
		assertEquals(0, wins);
	}
	
	@Test
	void testHasEnoughCredits() {
		Slots slots = new Slots();
		
		boolean enoughCredits = slots.hasEnoughCredits();
		
		assertEquals(true, enoughCredits);
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