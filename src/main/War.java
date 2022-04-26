package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class War {

	private Deck humanCards;
	private Deck cpuCards;
	private Deck warDeck;

	/**
	 * Returns new War object
	 * 
	 * @param numDecks specifies the number of decks to distribute among players
	 */
	public War(int numDecks) {
		initializeDecks();
		Deck d = new Deck(numDecks);
		
		// deal cards to players
		boolean turn = false;
		while (d.getSize() > 0) {
			if (turn) humanCards.add(d.deal());
			else cpuCards.add(d.deal());
			turn = !turn;
		}
	}

	/**
	 * Overloaded constructor to create War object with default 1 deck
	 */
	public War() {
		this(1);
	}

	/**
	 * Main handler for a game of war
	 * 
	 * @param scan a Scanner object passed from the main method of the casino program
	 */
	public void play(Scanner scan) {
		// introduction
		printWelcome();
		boolean resume = handleInput(scan);
		printTable();
		
		// all game functionality
		while (resume) {
			flipAndCompare(scan);
			if (endGame()) break;
			resume = handleInput(scan);
		}
	}
	
	/**
	 * Detects empty decks among players
	 * 
	 * @return boolean indicating whether game is over
	 */
	private boolean endGame() {
		if (humanCards.getSize() < 1) {
			cpuWins();
			return true;
		}
		else if (cpuCards.getSize() < 1) {
			humanWins();
			return true;
		}
		return false;
	}
	
	private void humanWins() {
		String msg = "You win! Though you did just play a full game of war, so....";
		System.out.println(msg);
	}
	
	private void cpuWins() {
		String msg = "You lost, dude...";
		System.out.println(msg);
	}

	/**
	 * Pulls top card from each player's deck and passes to the comparator
	 * 
	 * @param scan
	 */
	public void flipAndCompare(Scanner scan) {
		Card humanRoundCard = humanCards.deal();
		Card cpuRoundCard = cpuCards.deal();
		printRoundState(humanRoundCard, cpuRoundCard);
		handleRoundResult(humanRoundCard, cpuRoundCard, scan);
	}
	
	/**
	 * Compares round cards
	 * 
	 * @param humanRoundCard
	 * @param cpuRoundCard
	 * @param scan
	 */
	public int handleRoundResult(Card humanRoundCard, Card cpuRoundCard, Scanner scan) {
		int winner = humanRoundCard.compareTo(cpuRoundCard);
		switch (winner) {
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
		return winner;
	}

	/**
	 * In the event of a win
	 * 
	 * @param human Card
	 * @param cpu Card
	 */
	public void handleRoundWin(Card human, Card cpu) {
		// add winnings to human deck
		humanCards.add(human, cpu);
		humanCards.shuffle();
		String msg = "Win!  ";
		System.out.println(msg + "You: " + humanCards.getSize() + "  CPU: " + cpuCards.getSize());
		// if there was a war preceding this win, handle appropriately
		handleSpoilsOfWar(true);
	}

	/**
	 * In the event of a loss
	 * 
	 * @param human
	 * @param cpu
	 */
	public void handleRoundLoss(Card human, Card cpu) {
		// add winnings to cpu deck
		cpuCards.add(human, cpu);
		cpuCards.shuffle();
		String msg = "Loss :(  ";
		System.out.println(msg + "You: " + humanCards.getSize() + "  CPU: " + cpuCards.getSize());
		// if there was a war preceding this loss, handle appropriately
		handleSpoilsOfWar(false);
	}

	/**
	 * In the event of a tie
	 * 
	 * @param human
	 * @param cpu
	 * @param scan
	 */
	public void handleRoundWar(Card human, Card cpu, Scanner scan) {
		System.out.print("It's a war!");
		boolean resume = handleInput(scan);
		int cardNumber = 0;
		// deal three cards face down on user input
		while (resume && cardNumber < 3) {
			// add face-down cards to the war queue, to be distributed on termination of war
			warDeck.add(flipWithoutComparing());
			cardNumber++;
			resume = handleInput(scan);
		}
	}
	
	/**
	 * In the event a war (or chain of wars) end(s)
	 * 
	 * @param didWin
	 */
	private void handleSpoilsOfWar(boolean didWin) {
		// this is called every time there's a win or loss, so we make sure that the war queue does have cards in it
		if (warDeck.getSize() > 0) {
			// "turn cards over"
			String msg = didWin ? "You got: " : "CPU got: ";
			System.out.println(msg + warDeck.listCards());
			// add war queue to winner's deck
			while (warDeck.getSize() > 0) {
				if (didWin) humanCards.add(warDeck.deal());
				else cpuCards.add(warDeck.deal());
			}
		}
	}
	
	/**
	 * Deals cards without displaying or comparing; used in war
	 * @return
	 */
	public List<Card> flipWithoutComparing() {
		Card humanCard = humanCards.deal();
		Card cpuCard = cpuCards.deal();
		// show "face-down" cards
		printRoundState();
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
		warDeck = new Deck(0);
	}

	private static void printWelcome() {
		String msg = "This is a simple one--just press Enter when you want to flip your card\n";
		msg += "Are you ready? (Press Enter, or any other keuy to quit)";
		System.out.println(msg);
	}

	private void printRoundState(Card humanCard, Card cpuCard) {
		String msg = humanCard.toString() + "        " + cpuCard.toString() + "   ";
		System.out.println(msg);
	}
	
	/**
	 * Overloaded version of `printRoundState()` used to display face-down cards
	 */
	private static void printRoundState() {
		System.out.print("*         *    ");
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
	
	public int getHumanDeckSize() {
		return humanCards.getSize();
	}
	
	public int getCpuDeckSize() {
		return cpuCards.getSize();
	}

}
