////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2014
//  Section:  4102
// 
//  Project:  Project1
//  File:     Hand.java
//  
//  Name:     Tim Moss
//  Email:    thmoss@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

public class Hand 
{
	private String user; // name of user
	private int game; // number of games played
	private double cash; // players cash
	private int numCardsHand; // number of cards the player has
	private Card[] hand = new Card[10]; // array to hold cards
	
	/**
	 * Sets the hand user to the userName passed in
	 * 
	 * @parameter userName passes the user name in
	 */
	public void setUserName(String userName)
	{
		user = userName;
	}
	
	/**
	 * Returns the user when called
	 * 
	 * @return user string of the user
	 */
	public String getUserName()
	{
		return user;
	}
	
	/**
	 * Increases the game counter by 1
	 * 
	 */
	public void setGameNumber()
	{
		game++;
	}
	
	/**
	 * Returns the number of games played
	 * 
	 * @return game current game number
	 */
	public int getGameNumber()
	{
		return game;
	}
	
	/**
	 * Sets the cash to the cash in Hand
	 * 
	 * @parameter cash cash passed in
	 */
	public void setCash(double cash)
	{
		this.cash = cash;
	}
	
	/**
	 * Returns the cash total
	 * 
	 * @return cash total cash possessed
	 */
	public double getCash()
	{
		return cash;
	}
	
	/**
	 * Makes sure the hand has no cards
	 * 
	 */
	public void emptyHand()
	{
		for(int i = 0; i < 10; i++)
		{
			hand[i] = null;
		}
		numCardsHand = 0;
	}
	
	/**
	 * Get the card passed in from the deck and add it to the
	 * hand, unless number of cards is 10
	 * 
	 * @return whether the handSum function is greater or less than 21
	 */
	public boolean addCardHand(Card card)
	{
		if(numCardsHand == 10) // if player has 10 cards
		{
			System.out.print("Reached max of 10 cards");
		}
		
		hand[numCardsHand] = card; // add card to players hand
		numCardsHand++; // increase number of cards the player holds
		
		return (handSum() <= 21); // if play score less than or equal to 21		
	}
	
	/**
	 * Calculates the total of the cards in hand
	 * 
	 * @return sum sum of the cards in hand
	 */
	public int handSum()
	{
		int sum = 0;
		int cardFaceNum;
		int acesNum = 0;
		
		// loop through each card in hand to calculate total value
		for(int i = 0; i < numCardsHand; i++)
		{
			cardFaceNum = hand[i].getNumber();
			
			if(cardFaceNum == 1) // ace value
			{
				acesNum++;
				sum += 11;
			}
			else if(cardFaceNum > 10) // J, Q, K
			{
				sum += 10;
			}
			else
			{
				sum += cardFaceNum; // face value (2, 3...)
			}
		}
		
		// if the sum passes 21 and we have aces in hand,
		// set them to 1 instead of 11
		while(sum > 21 && acesNum > 0)
		{
			sum -= 10;
			acesNum--;
		}
		
		return sum;
	}
	
	/**
	 * Prints the cards in hand
	 * 
	 */
	public void printCards()
	{
		for(int i = 0; i < numCardsHand; i++)
		{
			System.out.printf(" %s", hand[i].toString());
		}
	}
}
