package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class War {

	private Deck humanCards;
	private Deck cpuCards;
	
	// TODO: format output better
	// TODO: error catching when decks are empty

	/**
	 * Returns new War object
	 * 
	 * @param numDecks specifies the number of decks to distribute among players
	 */
	public War(int numDecks) {
		initializeDecks();
		Deck d = new Deck(numDecks);
		// TODO: less-janky means of dealing cards? Might have to update the Deck class
		boolean turn = false;
		while (d.getSize() > 0) {
			if (turn) humanCards.add(d.deal());
			else cpuCards.add(d.deal());
			turn = !turn;
		}
	}

	public War() {
		this(1);
	}

	private void play(Scanner scan) {
		printWelcome();
		boolean resume = handleInput(scan);
		printTable();
		while (resume) {
			flipAndCompare(scan);
			resume = handleInput(scan);
		}
	}

	private int flipAndCompare(Scanner scan) {
		Card humanRoundCard = humanCards.deal();
		Card cpuRoundCard = cpuCards.deal();
		printRoundState(humanRoundCard, cpuRoundCard);
		int roundState = humanRoundCard.compareTo(cpuRoundCard);
		switch (roundState) {
		case -1:
			handleRoundLoss(humanRoundCard, cpuRoundCard);
			break;
		case 0:
			handleRoundWar(humanRoundCard, cpuRoundCard, scan);
			break;
		case 1:
			handleRoundWin(humanRoundCard, cpuRoundCard);
			break;
		}
		return roundState;
	}

	private void handleRoundWin(Card human, Card cpu) {
		humanCards.add(human, cpu);
		// TODO: re-add discard pile?
		humanCards.shuffle();
		System.out.println("Win!");
	}

	private void handleRoundLoss(Card human, Card cpu) {
		cpuCards.add(human, cpu);
		cpuCards.shuffle();
		System.out.println("Loss :(");
	}

	private void handleRoundWar(Card human, Card cpu, Scanner scan) {
		System.out.print("It's a war!");
		boolean resume = handleInput(scan);
		int cardNumber = 0;
		List<Card> cardQueue = new ArrayList<Card>();
		while (resume && cardNumber < 3) {
			cardQueue.addAll(flipWithoutComparing());
			cardNumber++;
			resume = handleInput(scan);
		}
		resume = handleInput(scan);
		int winState = flipAndCompare(scan);
		
	}
	
	private List<Card> flipWithoutComparing() {
		Card humanCard = humanCards.deal();
		Card cpuCard = cpuCards.deal();
		printRoundState(humanCard, cpuCard);
		List<Card> out = new ArrayList<Card>();
		out.add(cpuCard);
		out.add(humanCard);
		return out;
	}

	/**
	 * Reads user input. Enter means continue, anything else means quit. Real
	 * clicky.
	 * 
	 * @param scan passed in from the main menu so we don't have multiple scanners
	 *             open on System.in
	 * @return int 1 if continue, 0 if quit
	 */
	private static boolean handleInput(Scanner scan) {
		String input = scan.nextLine();
		if (input.isEmpty())
			return true;
		return false;
	}

	private void initializeDecks() {
		humanCards = new Deck(0);
		cpuCards = new Deck(0);
	}

	private static void printWelcome() {
		String msg = "This is a simple one--just press Enter when you want to flip your card\n";
		msg += "Are you ready? (Press Enter, or any other keuy to quit)";
		System.out.println(msg);
	}

	private static void printRoundState(Card humanCard, Card cpuCard) {
		String msg = humanCard.toString() + "        " + cpuCard.toString() + "   ";
		System.out.print(msg);
	}
	
	private void printTable() {
		String msg = "You       CPU\n";
		System.out.println(msg);
	}

	public String getState() {
		String out = "Your cards: " + humanCards + "\n";
		out += "Opponent cards: " + cpuCards + "\n";

		return out;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		War w = new War();
		w.play(s);
		s.close();
	}

}
