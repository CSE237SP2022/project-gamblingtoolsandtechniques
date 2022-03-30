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

	public void initiate() {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		while (input >= 0) {
			System.out.println("Plays: " + numPlays + " Wins: " + numWins + " Credits: " + credits);
			System.out.println("Play slots? (enter number of times to play, -1 for quit)");
		    input = scan.nextInt();
		    for(int i=0; i<input; i++) {
		    	this.play();
		    }
		}
	    System.out.println("Bye");
	    scan.close();
	}
	
	public void play() {
		if(this.hasEnoughCredits()) {
			credits--;
			numPlays++;
			int[] slotsNumbers = this.generateNumbers();
			this.printNumbers(slotsNumbers);
			if(checkIfWin(slotsNumbers)) {
				credits += 10;
				numWins++;
				System.out.println("Congrats! You win!\n");
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
	
	public static boolean checkIfWin(int[] slotsNumbers) {
		return (slotsNumbers[0] == slotsNumbers[1] && slotsNumbers[1] == slotsNumbers[2]);
	}
	
	

	public static void main(String[] args) {
		Slots slots = new Slots();
		slots.initiate();
	}

}
