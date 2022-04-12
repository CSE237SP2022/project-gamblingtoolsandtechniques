package main;

public class War {
	
	private Deck humanCards;
	private Deck cpuCards;
	
	/**
	 * Returns new War object
	 * @param numDecks specifies the number of decks to distribute among players
	 */
	public War(int numDecks) {
		Deck d = new Deck(numDecks);
		// TODO: less-janky means of dealing cards? Might have to update the Deck class
		boolean turn = false;
		while (d.getSize() >= 0) {
			if (turn) humanCards.add(d.deal()); else cpuCards.add(d.deal());;
			turn = !turn;
		}
	}
	
	public War() {
		this(1);
	}
	
	public String getState() {
		String out = "Your cards: " + humanCards + "\n";
		out += "Opponent cards: " + cpuCards + "\n";
		
		return out;
	}
	
	

}
