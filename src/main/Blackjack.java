package main;

import java.util.Scanner;
import java.lang.Math;

public class Blackjack {
	
	private int credits;
	private int rounds;
	private int wins;
	private int dealerTotal;
	private int dealerShow;
	private int playerTotal;
	private int wager;
	private int card;
	private int winState;
	
	public Blackjack(int initialCredits) {
		credits = initialCredits;
		rounds = 0;
		wins = 0;
		dealerTotal = 0;
		dealerShow = 0;
		playerTotal = 0;
		wager = -1;
		card = 0;
		winState = 0;
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
	
	public int getWager() {
		return this.wager;
	}
	
	public int getCard() {
		return this.card;
	}
	
	public int getWinState() {
		return this.winState;
	}
	
	public void setDealerTotal(int dealerTotal) {
		this.dealerTotal = dealerTotal;
	}
	
	public void setPlayerTotal(int playerTotal) {
		this.playerTotal = playerTotal;
	}
	
	public void setCard(int card) {
		this.card = card;
	}

	private String setupHelper(Scanner scan) {
		String input2 = "";
		System.out.println("Rounds: " + getRounds() + " Wins: " + getWins() + " Credits: " + getCredits());
		this.playCaller(scan);
		System.out.println("Would you like to play another round of blackjack? (y/n)");
	    input2 = scan.nextLine();
	    if(!input2.equals("y")) {
	    	input2 = "n";
	    }
	    return input2;
	}
	
	public void setup(Scanner scan) {
		String input = "y";
		while (input.equals("y")) {
			input = this.setupHelper(scan);
		}
	    System.out.println("End of game");
	}
	
	public void winProtocol() {
		this.credits += this.wager;
		this.wins++;
		System.out.println("You win! You double your wager.\n");
	}
	
	public void loseProtocol() {
		this.credits -= this.wager;
		System.out.println("You bust. You lose your wager.\n");
	}
	
	public void playCallerHelper(int winState) {
		if(winState == 1) {
			this.winProtocol();
		}
		else if(winState == 2) {
			this.loseProtocol();
		}
		else {
			System.out.println("You draw. You keep your wager.\n");
		}
		System.out.println("You now have " + this.getCredits() + " credits.");
	}
	
	public void playCaller(Scanner scan) {
		this.wager = this.setWager(scan);
		if(this.hasEnoughCredits(this.wager)) {
			this.rounds++;
			this.playCallerHelper(this.round(scan));
		}
		else {
			System.out.println("You can't wager more than you have.");
			this.playCaller(scan);
		}
	}
	
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
	
	private int setWager(Scanner scan) {
		System.out.println("How much would you like to wager this round? (int)");
		int wager = getIntInput(scan);
		while (wager == 0) {
			System.out.println("Please enter a positive integer.");
			wager = getIntInput(scan);
		}
		return wager;
	}

	public void roundWinState() {
		if((playerTotal > dealerTotal && playerTotal <= 21) || (playerTotal <= 21 && dealerTotal > 21)) {
    		this.winState = 1;
    	}
    	else if (playerTotal < dealerTotal){
    		this.winState = 2;
    	}
	}
	
	public void playDealer() {
		while(this.dealerTotal < 17) {
    		System.out.println("The dealer has " + this.dealerTotal + " and needs to hit.");
    		this.addDealerCard();
    	}
	}
	
	public boolean gamePlayHelper(String choice) {
		if(choice.equals("y")) {
	    	this.addPlayerCard();
	    	return false;
	    }
	    else {
	    	this.playDealer();
	    	System.out.println("The dealer has " + this.dealerTotal + ". You have " + this.playerTotal + ".");
	    	this.roundWinState();
	    	return true;
	    }
	}
	
	public boolean gamePlay(Scanner scan) {
		if(playerTotal > 21) {
			this.winState = 2;
			return true;
		}
		else {
			System.out.println("\nThe dealer is showing " + this.dealerShow + ". Would you like to hit? (y/n)");
			String choice = scan.nextLine();
			return gamePlayHelper(choice);
		}
	}
	
	public int round(Scanner scan) {
		boolean gameOver = false;
		this.winState = 0;
		this.roundSetup();
		scan.nextLine();
		while(!gameOver) {
			gameOver = this.gamePlay(scan);
		}
		return winState;
	}

	public void roundSetup() {
		this.playerTotal = 0;
		this.dealerTotal = 0;
		this.dealerShow = 0;
		System.out.println("\nRound " + this.getRounds() + " start:\n");
		this.addDealerCard();
		this.addPlayerCard();
		this.addDealerCard();
		this.addPlayerCard();
	}
	
	public void aceChange(int total) {
		if(total + 11 > 21) {
			this.card = 1;
		}
		else {
			this.card = 11;
		}
	}
	
	public String cardNamer(int total) {
		String cardName = "" + card;
		if(this.card == 10) {
			cardName = "face";
		}
		else if(this.card == 1 || this.card == 11) {
			cardName = "ace";
			this.aceChange(total);
		}
		return cardName;
	}
	
	public void addDealerCard() {
		this.card = (int)(Math.random()*11) + 1;
		String cardName = this.cardNamer(this.getDealerTotal());
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
		this.card = (int)(Math.random()*11) + 1;
		String cardName = this.cardNamer(this.getPlayerTotal());
		this.playerTotal += card;
		System.out.println("You receive a " + cardName + " card and have a total of " + this.getPlayerTotal() + ".");
	}
	
	public boolean hasEnoughCredits(int wager) {
		return (this.credits >= wager);
	}
	

	public static void main(String[] args) {
		Blackjack blackjack = new Blackjack(50);
		Scanner scan = new Scanner(System.in);
		blackjack.setup(scan);
		scan.close();
	}
	
}
