package main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
	
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
		System.out.println("2 - Buy chips");
		System.out.println("3 - Exit");
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
	 * Main method for the casino program
	 * TODO: separate into more methods
	 * 
	 * @return <i>None</i>
	 */
	public static void main(String[] args) {
		
		// initialize state
		boolean isPlaying = true;
		int menuState = 1;
		int input = 0;
		
		printWelcomeMessage();
		
		Scanner in = new Scanner(System.in);
		
		while (isPlaying) {
			
			switch (menuState) {
			
			// if user is on the main menu...
			case 1:
				
				// show menu options
				printMenuOptions();
				
				// wait for input
				input = getIntInput(in);
				
				switch (input) {
				case 1:
					// go to game menu
					menuState = 2;
					break;
				case 2:
					// TODO: trigger chips purchase module here
					break;
				case 3:
					// exit the program
					isPlaying = false;
					break;
				default:
					printSelectionWarning();
					break;
				}
				break;
				
			// if user is on the game menu
			case 2:
				
				// show game options
				printGameOptions();
				
				// wait for input
				input = getIntInput(in);
				
				switch (input) {
				case 1:
					Slots s = new Slots();
					s.initiate(in);
					input = 0;
					break;
				case 2:
					War w = new War();
					w.play(in);
					break;
				case 3:
					Blackjack b = new Blackjack(50);
					b.setup(in);
					input = 0;
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
				break;
			}
		}
		
		printGoodBye();
		
		in.close();
		
	}

}
