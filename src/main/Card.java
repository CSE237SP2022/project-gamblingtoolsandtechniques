package main;

public class Card implements Comparable<Card> {
	
	// inspired by https://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/cards.html

	// expose "enum" for other classes
	public static final int SPADE = 3;
	public static final int HEART = 2;
	public static final int CLUB = 1;
	public static final int DIAMOND = 0;

	// helps us easily access human-readable values
	private static final String[] Suit = { "D", "C", "H", "S" };
	private static final String[] Rank = { "*", "*", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	// encoded as 0, 1, 2, 3
	private byte cardSuit;
	// encoded as [2...14] for my personal sanity when accessing the print array
	private byte cardRank;

	/**
	 * Returns one card object that can be compared to other cards.
	 * 
	 * @param suit The suit of the card. 0 = diamond, 1 = club, 2 = heart, 3 = spade
	 * @param rank The rank of the card. Obeys ordinality of normal deck (with aces high)
	 * @throws IllegalArgumentException
	 */
	public Card(int suit, int rank) throws IllegalArgumentException {
		
		// disallow illegal card construction. Shouldn't actually be a problem.
		if (suit < 0 || suit > 3 || rank < 2 || rank > 14) {
			throw new IllegalArgumentException("Invalid card; make sure 0 <= suit <= 3, 2 <= rank <= 14.");
		}
		
		cardRank = (byte) rank;
		cardSuit = (byte) suit;
	}

	// read-access methods
	public int suit() {
		return (cardSuit);
	}

	public String suitStr() {
		return (Suit[cardSuit]);
	}

	public int rank() {
		return (cardRank);
	}

	public String rankStr() {
		return (Rank[cardRank]);
	}

	public String toString() {
		return (Rank[cardRank] + Suit[cardSuit]);
	}

	// make card object comparable
	@Override
	public int compareTo(Card o) {
		// compare only the ranks, not the suits
		if (cardRank > o.cardRank) return 1;
		else if (cardRank < o.cardRank) return -1;
		else return 0;
	}

}