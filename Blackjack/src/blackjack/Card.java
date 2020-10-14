package blackjack;

public class Card {
	
	private Suit suit;
	private Values value;
	
	public Card(Suit suit, Values value) {
		this.suit = suit;
		this.value = value;
	}

	public Values getValue() {
		return this.value;
	}
	
	public String toString(){
		return this.suit.toString() + "-" + this.value.toString();
	
	}
}
