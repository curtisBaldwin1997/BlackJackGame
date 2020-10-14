package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	//Instance variables
	private ArrayList<Card> cards;

	
	//Constructor arraylist of cards
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void createFullDeck() {
		
		//Generate cards
		for(Suit cardSuit : Suit.values()) {  //For each loop to go through four suit values
			for(Values cardValue : Values.values()) { //For each loop to go through values enum. generates 52 cards
				//Add new card to the deck
				this.cards.add(new Card(cardSuit, cardValue)); //calling constructor in Card and adding new card
			}
		}
	}
	
	public void moveAllToDeck(Deck moveTo) {
		int thisDeckSize = this.cards.size();
		
		for(int i = 0; i < thisDeckSize; i++) {
			moveTo.addCard(this.getCard(i));
		}
		
		for(int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public void removeCard(int i ) {
		this.cards.remove(i);
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	public void draw(Deck comingFrom) {
		this.cards.add(comingFrom.getCard(0));
		comingFrom.removeCard(0);
	}
	
	//Return value of cards in deck
	public int cardsValue() {
		int totalValue = 0;
		int aces = 0;
		
		for(Card aCard: this.cards) {
			switch(aCard.getValue()) {
			case Two: totalValue += 2; break;
			case Three: totalValue += 3; break;
			case Four: totalValue += 4; break;
			case Five: totalValue += 5; break;
			case Six: totalValue += 6; break;
			case Seven: totalValue += 7; break;
			case Eight: totalValue += 8; break;
			case Nine: totalValue += 9; break;
			case Ten: totalValue += 10; break;
			case Jack: totalValue += 10; break;
			case Queen: totalValue += 10; break;
			case King: totalValue += 10; break;
			case Ace: aces += 1; break;
			}
		}
		
		for(int i = 0; i < aces; i++) {
			if(totalValue > 10) {
				totalValue += 1;
			}else {
				totalValue += 11;
			}
		}
		
		return totalValue;
	}
	
	//Randomly go through deck of cards and put them in a temp deck and then set the org deck to the temp in order to shuffle
	public void shuffle() {
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		Random random = new Random();
		int randomCardIndex = 0;
		int originalSize = this.cards.size();
		
		for(int i = 0; i < originalSize; i++) {
			randomCardIndex = random.nextInt((this.cards.size()-1 - 0) +1 ) + 0; // random card
			tempDeck.add(this.cards.get(randomCardIndex)); // add random card to temp deck
			//Remove from original deck
			this.cards.remove(randomCardIndex);
		}
		
		this.cards = tempDeck;
	}
	
	public String toString() {
		String cardList = ""; 
		
		for(Card aCard: this.cards) { //For each loop to go through all cards in arraylist
			cardList += "\n" + aCard.toString(); // new line for every card, then prints out all cards
		
		}
		return cardList; // return the string
		
	}
}
