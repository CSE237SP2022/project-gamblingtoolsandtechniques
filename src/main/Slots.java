package main;

import java.util.Scanner;

public class Slots {
	
	private int credits;
	private int numPlays;
	private int numWins;
	
	public Slots() {
		credits = 50;
		numPlays = 0;
		numWins = 0;
	}
	
	public int getCredits() {
		return credits;
	}

	public int getNumPlays() {
		return numPlays;
	}

	public int getNumWins() {
		return numWins;
	}

	public void initiate(Scanner s) {
//		Scanner scan = new Scanner(System.in);
		int input = 0;
		while (input >= 0) {
			this.printStartMessages();
			try {
				input = s.nextInt();
			}
			catch (Exception e){
				input = nonNumberInputProtocol(s);
			}
			if(input < -1) {
				input = inputNegativeProtocol();
			}
			for(int i=0; i<input; i++) {
		    	this.play();
		    }
		}
//		scan.close();
	    System.out.println("Bye");
	}

	private int inputNegativeProtocol() {
		int input = 0;
		System.out.println("Please enter a number to play, or -1 to quit");
		return input;
	}

	public int nonNumberInputProtocol(Scanner scan) {
		int input = 0;
		if (scan.hasNext()) scan.next();
		if(scan.hasNextLine()) scan.nextLine();
		System.out.println("Please enter a number");
		return input;
	}

	private void printStartMessages() {
		System.out.println("Plays: " + numPlays + " Wins: " + numWins + " Credits: " + credits);
		System.out.println("Play slots? (enter number of times to play, -1 for quit)");
	}
	
	public void play() {
		if(this.hasEnoughCredits()) {
			this.initialStatsUpdate();
			int[] slotsNumbers = this.generateNumbers();
			this.printNumbers(slotsNumbers);
			if(checkIfWin(slotsNumbers)) {
				this.winProtocol();
			}
			else {
				System.out.println("You lose :(\n");
			}
		}
		else {
			System.out.println("You don't have enough money :(");
		}
	}
	
	public boolean hasEnoughCredits() {
		return (this.credits > 0);
	}
	
	public int[] generateNumbers() {
		int[] slotsNumbers = new int[3];
		for(int i=0; i<3; i++) {
			slotsNumbers[i] = (int)(Math.random() * 5);
		}
		return slotsNumbers;
	}
	
	public void printNumbers(int[] slotsNumbers) {
		for(int i=0; i<slotsNumbers.length; i++) {
			System.out.print(slotsNumbers[i] + "... ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void initialStatsUpdate() {
		credits--;
		numPlays++;
	}
	
	public static boolean checkIfWin(int[] slotsNumbers) {
		return (slotsNumbers[0] == slotsNumbers[1] && slotsNumbers[1] == slotsNumbers[2]);
	}
	
	public void winProtocol() {
		credits += 10;
		numWins++;
		System.out.println("Congrats! You win!\n");
	}

	public static void main(String[] args) {
		Slots slots = new Slots();
		Scanner scan = new Scanner(System.in);
		slots.initiate(scan);
		scan.close();
	}

}
