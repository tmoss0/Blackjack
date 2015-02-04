////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2014
//  Section:  4102
// 
//  Project:  Project1
//  File:     DeckOfCards.java
//  
//  Name:     Tim Moss
//  Email:    thmoss@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * Implementation for the DeckOfCards object.
 * 
 * @author Tim Moss
 *
 */

public class DeckOfCards 
{
	private Card[] cards; // array of cards to hold deck
	int cardCounter = 0; // number of cards in a deck
	
	/**
	 * DeckOfCards constructor
	 * 
	 */
	public DeckOfCards()
	{
		cardCounter = 52; // cards per deck
		cards = new Card[cardCounter]; // actual deck
		
		int cardPlace = 0;
		// for loop for deck		
		// for loop for each suit
		for(int k = 0; k < 4; k++)
		{
			// for loop for each value
			for(int l = 1; l <= 13; l++)
			{
				cards[cardPlace] = new Card(Suit.values()[k], l);
				cardPlace++;
			}
		}		
		// shuffle deck of cards
		Random rn = new Random();
		Card temp;
		
		int j;
		for(int i = 0; i < cardCounter; i++)
		{
			j = rn.nextInt(cardCounter);
			temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}
	}
	
	/**
	 * Takes the first card from the deck and deals it
	 * 
	 * @return first card to be dealt
	 */
	public Card dealCard()
	{
		// first card in deck
		Card first = cards[0];
		
		for(int i = 1; i < cardCounter; i++)
		{
			cards[i - 1] = cards[i];
		}		
		cards[cardCounter - 1] = null;
		
		return first;
	}
}
