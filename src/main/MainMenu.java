package main;

import java.util.Scanner;

public class MainMenu {
	
	// initialize state
	private static boolean isPlaying = true;
	private static int menuState = 1;
	private static int input = 0;
	
	/**
	 * Prints a welcome message. Should be triggered when user opens casino
	 * 
	 * @return <i>None</i>
	 */
	static void printWelcomeMessage() {
		System.out.println("Welcome to the 237 Casino! Please select an option from the list");
	}
	
	/**
	 * Prints main menu options
	 * 
	 * @return <i>None</i>
	 */
	static void printMenuOptions() {
		System.out.println("1 - Play a game");
		System.out.println("2 - Exit");
	}
	
	/**
	 * Prints game choices
	 * 
	 * @return <i>None</i>
	 */
	static void printGameOptions() {
		System.out.println("1 - Slots");
		System.out.println("2 - War");
		System.out.println("3 - Blackjack");
		System.out.println("4 - Go back");
	}
	
	/**
	 * Prints an "invalid selection" message
	 * 
	 * @return: <i>None</i>
	 */
	static void printSelectionWarning() {
		System.out.println("Invalid option; please select from the following menu");
	}
	
	/**
	 * Prints a goodbye message
	 */
	static void printGoodBye() {
		System.out.println("Goodbye! Come back soon");
	}
	
	/**
	 * Gets the next valid integer from user input
	 * 
	 * @return int 0 if invalid, or choice if valid
	 */
	public static int getIntInput(Scanner in) {
		int input = 0;
		try {
			input = in.nextInt();
		} catch (Exception e) {
			input = 0;
			if (in.hasNext()) in.next();
			if (in.hasNextLine()) in.nextLine();
		}
		return input;
	}
	
	/**
	 * Handles functionality for the main casino menu
	 * @param scan
	 */
	private static void mainMenu(Scanner scan) {
		// show menu options
		printMenuOptions();
		// wait for input
		input = getIntInput(scan);
		switch (input) {
		case 1:
			// go to game menu
			menuState = 2;
			break;
		case 2:
			// exit the program
			isPlaying = false;
			break;
		default:
			printSelectionWarning();
			break;
		}
	}
	
	/**
	 * Handles functionality for the game menu
	 * @param scan
	 */
	private static void gameMenu(Scanner scan) {
		// show game options
		printGameOptions();
		// wait for input
		input = getIntInput(scan);
		switch (input) {
		case 1:
			triggerSlots(scan);
			break;
		case 2:
			triggerWar(scan);
			break;
		case 3:
			triggerBlackjack(scan);
			break;
		case 4:
			// go back to main menu
			menuState = 1;
			break;
		default:
			printSelectionWarning();
			input = 0;
			break;
		}
	}
	
	private static void triggerSlots(Scanner scan) {
		Slots s = new Slots();
		s.initiate(scan);
		input = 0;
	}
	
	private static void triggerWar(Scanner scan) {
		War w = new War();
		w.play(scan);
		input = 0;
	}
	
	private static void triggerBlackjack(Scanner scan) {
		Blackjack b = new Blackjack(50);
		b.setup(scan);
		input = 0;
	}

	/**
	 * Main method for the casino program
	 * TODO: separate into more methods
	 * 
	 * @return <i>None</i>
	 */
	public static void main(String[] args) {
		printWelcomeMessage();
		Scanner in = new Scanner(System.in);
		while (isPlaying) {
			switch (menuState) {
			// if user is on the main menu...
			case 1:
				mainMenu(in);
				break;
			// if user is on the game menu
			case 2:
				gameMenu(in);
				break;
			}
		}
		printGoodBye();
		in.close();
	}

}
