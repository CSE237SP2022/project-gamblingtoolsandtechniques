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
	void testPlayQuit() {
		War w = new War();
		Scanner scan = new Scanner("q\n");
		w.play(scan);
	}
	
	@Test
	void testPlayThenQuit() {
		War w = new War();
		Scanner scan = new Scanner("\n\n\nq\n");
		w.play(scan);
	}
	
	@Test
	void testEndGame() {
		War w = new War(0); // initialize with no cards so conditional in endGame is met
		w.endGame();
	}

	@Test
	void testFlipAndCompare() {
		War w = new War();
		w.flipAndCompare(new Scanner("\n\n\n\n\n\n"));
		// tough to account for randomness; just check that either player won the round
		assertTrue(27 == w.getCpuDeckSize() || 27 == w.getHumanDeckSize());
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
	void testHandleRoundWar() {
		War w = new War();
		Scanner scan = new Scanner("\n\n\n\nq\n");
		w.handleRoundWar(new Card(1, 10), new Card(1, 10), scan);
		assertEquals(6, w.getWarDeckSize());
	}
	
	@Test
	void testHandleSpoilsOfWar() {
		War w = new War();
		Scanner scan = new Scanner("\n\n\n\nq\n");
		w.handleRoundWar(new Card(1, 10), new Card(1, 10), scan);
		w.handleSpoilsOfWar(true);
		assertEquals(29, w.getHumanDeckSize());
	}
	
	@Test
	void testFlipWithoutComparing() {
		War w = new War();
		List<Card> flipped = w.flipWithoutComparing();
		assertInstanceOf(List.class, flipped);
	}
	
	@Test
	void testHandleInputResume() {
		War w = new War();
		Scanner scan = new Scanner("\n");
		assertTrue(w.handleInput(scan));
	}
	
	@Test
	void testHandleInputQuit() {
		War w = new War();
		Scanner scan = new Scanner("q\n");
		assertFalse(w.handleInput(scan));
	}
	
	@Test
	void testGetState() {
		War w = new War(0);
		String expected = "Your cards: Number of cards: 0\n\n";
		expected += "Opponent cards: Number of cards: 0\n\n";
		assertEquals(expected, w.getState());
	}

}
