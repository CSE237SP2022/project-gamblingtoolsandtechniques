package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Card;
import main.War;

class WarTest {
	
	/*
	 * Many of these tests are a little contrived... 
	 * most of the methods in the War class support interactive gameplay, 
	 * much of which is random or state-dependent. I think we wouldn't 
	 * test private or void methods under normal circumstances.
	 * However, I did my best to make some methods public and return 
	 * integers instead of void to increase test coverage
	 */

	@Test
	void testFlipAndCompare() {
		War w = new War();
		w.flipAndCompare(new Scanner(System.in));
		assertAll(
				() -> assertEquals(27, w.getCpuDeckSize()),
				() -> assertEquals(25, w.getHumanDeckSize())
				);
	}
	
	@Test
	void testHandleRoundResult() {
		War w = new War();
		int winner = w.handleRoundResult(new Card(1, 14), new Card(1, 3), new Scanner(System.in));
		assertEquals(1, winner);
	}
	
	@Test
	void testHandleRoundWin() {
		War w = new War();
		w.handleRoundWin(new Card(1, 14), new Card(1, 14));
		assertEquals(28, w.getHumanDeckSize());
	}
	
	@Test
	void testHandleRoundLoss() {
		War w = new War();
		w.handleRoundLoss(new Card(1, 14), new Card(1, 14));
		assertEquals(28, w.getCpuDeckSize());
	}
	
	@Test
	void testFlipWithoutComparing() {
		War w = new War();
		List<Card> flipped = w.flipWithoutComparing();
		assertInstanceOf(List.class, flipped);
	}

}
