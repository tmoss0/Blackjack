////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2014
//  Section:  4102
// 
//  Project:  Project1
//  File:     Card.java
//  
//  Name:     Tim Moss
//  Email:    thmoss@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

public class Card 
{		
	private Suit suit; // One of four suits 
	private int number; // Face value of the card (A, 2-10, J, Q, K)
	
	/**
	 * Constructor for Card class
	 * 
	 */
	public Card(Suit pSuit, int pNumber)
	{
		suit = pSuit;
		number = pNumber;
	}

	/**
	 * Returns the number of the card value
	 * 
	 * @return number face value of the card
	 */
	public int getNumber()
	{
		return number;
	}
	
	/**
	 * Replaces toString to display the face value of the card
	 * 
	 * @return the correct output for the cards
	 */
	public String toString()
	{
		String numString = null;
		switch(number)
		{
			case 2:
				numString = "2";
				break;
			case 3:			
				numString = "3";
				break;
			case 4:			
				numString = "4";
				break;
			case 5:
				numString = "5";
				break;
			case 6:
				numString = "6";
				break;
			case 7:
				numString = "7";
				break;
			case 8:
				numString = "8";
				break;
			case 9:
				numString = "9";
				break;
			case 10:
				numString = "10";
				break;
			case 11:
				numString = "Jack";
				break;
			case 12:
				numString = "Queen";
				break;
			case 13:
				numString = "King";
				break;
			case 1:
				numString = "Ace";
				break;
		}
		
		return numString + " | " + suit.toString();				
	}
}
