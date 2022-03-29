package main;

import java.util.Scanner;

public class MainMenu {
	
	public static int asdf() {
		return 1;
	}
	
	/*
	 * Prints a welcome message. Should be triggered when user opens casino
	 * 
	 * @return <i>None</i>
	 */
	static void printWelcomeMessage() {
		System.out.println("Welcome to the 237 Casino! Please select an option from the list");
	}
	
	/*
	 * Prints main menu options
	 * 
	 * @return <i>None</i>
	 */
	static void printMenuOptions() {
		System.out.println("1 - Play a game");
		System.out.println("2 - Buy chips");
		System.out.println("3 - Exit");
	}
	
	/*
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
	
	/*
	 * Prints an "invalid selection" message
	 * 
	 * @return: <i>None</i>
	 */
	static void printSelectionWarning() {
		System.out.println("Invalid option; please select from the following menu");
	}
	
	/*
	 * Prints a goodbye message
	 */
	static void printGoodBye() {
		System.out.println("Goodbye! Thank you for playing");
	}
	
	/*
	 * Gets the next valid integer from user input
	 */
	static int getIntInput(Scanner s) {
		// if the entry is not an integer
		while (! s.hasNextInt()) {
			// notify the user and flush the scanner
			System.out.println("Please enter a digit");
			s = new Scanner(System.in);
		}
		// if it is an integer, return that integer
		return s.nextInt();
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// initialize state
		boolean isPlaying = true;
		int menuState = 1;
		int input = 0;
		
		printWelcomeMessage();
		
		
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
					// TODO: trigger slots module
					break;
				case 2:
					// TODO: trigger war module
					break;
				case 3:
					// TODO: trigger blackjack module
					break;
				case 4:
					// go back to main menu
					menuState = 1;
					break;
				default:
					printSelectionWarning();
					break;
				}
				break;
			}
		}
		
		printGoodBye();
		
		in.close();
		
	}

}
