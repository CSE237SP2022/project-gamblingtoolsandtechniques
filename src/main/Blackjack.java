package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Blackjack {
	
	private int credits;
	private int rounds;
	private int wins;
	private int dealerTotal;
	private int dealerShow;
	private int playerTotal;
	
	public Blackjack(int initialCredits) {
		credits = initialCredits;
		rounds = 0;
		wins = 0;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getRounds() {
		return this.rounds;
	}

	public int getWins() {
		return this.wins;
	}
	
	public int getDealerTotal() {
		return this.dealerTotal;
	}
	
	public int getDealerShow() {
		return this.dealerShow;
	}
	
	public int getPlayerTotal() {
		return this.playerTotal;
	}
	
	public void setup() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("Would you like to play blackjack? (y/n)");
		input = scan.nextLine();
		//scan.close();
		while (input.equals("y")) {
			System.out.println("Rounds: " + getRounds() + " Wins: " + getWins() + " Credits: " + getCredits());
			this.play();
			System.out.println("Would you like to play another round of blackjack? (y/n)");
		    input = scan.nextLine();
		    //scan2.close();
		    if(!input.equals("y")) {
		    	input = "n";
		    }
		}
	    System.out.println("End of game");
	}
	
	public void play() {
		int wager = -1;
		System.out.println("How much would you like to wager this round?");
		while(wager < 0) {
			try{
				Scanner scan = new Scanner(System.in);
				wager = scan.nextInt();
			}
			catch(InputMismatchException e) {
				wager = -1;
			}
			if(wager < 0) {
				System.out.println("Please enter a positive integer.");
			}
		}
		int winState = 0;
		if(this.hasEnoughCredits(wager)) {
			this.rounds++;
			winState = this.round();
			if(winState == 1) {
				this.credits += wager;
				this.wins++;
				System.out.println("You win! You double your wager.\n");
			}
			else if(winState == 2) {
				this.credits -= wager;
				System.out.println("You bust. You lose your wager.\n");
			}
			else {
				System.out.println("You draw. You keep your wager.\n");
			}
			System.out.println("You now have " + this.getCredits() + " credits.");
		}
		else {
			System.out.println("You can't wager more than you have.");
			this.play();
		}
		//scan.close();
	}
	
	public int round() {
		boolean gameOver = false;
		int winState = 0;
		this.playerTotal = 0;
		this.dealerTotal = 0;
		this.dealerShow = 0;
		System.out.println("\nRound " + this.getRounds() + " start:\n");
		this.addDealerCard();
		this.addPlayerCard();
		this.addDealerCard();
		this.addPlayerCard();
		Scanner scan = new Scanner(System.in);
		String choice = "";
		while(!gameOver) {
			if(playerTotal > 21) {
				winState = 2;
				gameOver = true;
			}
			else {
				System.out.println("\nThe dealer is showing " + this.dealerShow + ". Would you like to hit? (y/n)");
				choice = scan.nextLine();
				if(choice.equals("y")) {
			    	this.addPlayerCard();
			    }
			    else {
			    	//play for the dealer automatically
			    	while(dealerTotal < 17) {
			    		System.out.println("The dealer has " + this.dealerTotal + " and needs to hit.");
			    		this.addDealerCard();
			    	}
			    	//finish round by comparing playerTotal to dealerTotal and 21
			    	System.out.println("The dealer has " + this.dealerTotal + ". You have " + this.playerTotal + ".");
			    	if(playerTotal > dealerTotal && playerTotal <= 21) {
			    		winState = 1;
			    	}
			    	else if(playerTotal < dealerTotal) {
			    		winState = 2;
			    	}
			    	gameOver = true;
			    }
			}
		}
		//scan.close();
		return winState;
	}
	
	public void addDealerCard() {
		int card = (int)(Math.random()*11) + 1;
		String cardName = "" + card;
		if(card == 10) {
			cardName = "face";
		}
		else if(card == 1 || card == 11) {
			cardName = "ace";
			if(this.getDealerTotal() + 11 > 21) {
				card = 1;
			}
			else {
				card = 11;
			}
		}
		if(this.getDealerTotal() == 0) {
			System.out.println("The dealer receives their hidden card");
		}
		else{
			this.dealerShow += card;
			System.out.println("The dealer receives a " + cardName + " card.");
		}
		this.dealerTotal += card;
	}
	
	public void addPlayerCard() {
		int card = (int)(Math.random()*11) + 1;
		String cardName = "" + card;
		if(card == 10) {
			cardName = "face";
		}
		else if(card == 1 || card == 11) {
			cardName = "ace";
			if(this.getPlayerTotal() + card > 21) {
				card = 1;
			}
		}
		this.playerTotal += card;
		System.out.println("You receive a " + cardName + " card and have a total of " + this.getPlayerTotal() + ".");
	}
	
	public boolean hasEnoughCredits(int wager) {
		return (this.credits >= wager);
	}
	

	public static void main(String[] args) {
		Blackjack blackjack = new Blackjack(50);
		blackjack.setup();
	}
	
}
