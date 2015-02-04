////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2014
//  Section:  4102
// 
//  Project:  Project1
//  File:     Game.java
//  
//  Name:     Tim Moss
//  Email:    thmoss@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Game 
{
	public static void main(String[] args)
	{
		// Variables
		String userName; // name of the player
		int userChoice = 0; // UI choice for player
		int totalGames = 0; // total games played
		int totalWins = 0; // times player won
		int totalLosses = 0; // times play lost
		double cash; // cash the player posessess	
		double wagerCash; // amount the player wages
		double totalWinnings = 0.0; // total winnings won from player
		boolean playerFinish = false; // flag for player to hit/stand
		boolean dealerFinish = false; // flag for dealer to hit/stand
		Scanner sc = new Scanner(System.in); // default scanner
		
		
		DeckOfCards deck = new DeckOfCards(); // create a new deck of cards object
		Hand dealersHand = new Hand(); // create a new hand object for the dealer
		Hand playersHand = new Hand(); // create a new hand object for the player 
		
		
		// name input
		System.out.print("Enter your first name >> ");
		userName = sc.next().trim();		
		playersHand.setUserName(userName.toUpperCase());
		
		// cash input
		System.out.print("Enter cash >> ");
		cash = sc.nextDouble();
		playersHand.setCash(cash);
	
		while(userChoice != 3)
		{
			// UI display
			System.out.println("--------------------------------------------");
			System.out.println("   MAIN MENU   ");
			System.out.println("--------------------------------------------");
			
			// user selects choice
			System.out.println("(1) Play game");
			System.out.println("(2) Show available cash");
			System.out.println("(3) Quit\n");
			
			// user choice input
			System.out.print(">> ");
			userChoice = sc.nextInt();
				
			switch(userChoice)
			{
			case 1:
				// clear cards from hand
				playersHand.emptyHand();
				dealersHand.emptyHand();
				
				playersHand.setGameNumber(); // increase game number by 1
				System.out.println("************************* START GAME " + playersHand.getGameNumber() + " ******************************");
				System.out.print("Enter Wager >> ");
				wagerCash = sc.nextDouble();
				
				// deal 2 cards to player and dealer
				playersHand.addCardHand(deck.dealCard());
				dealersHand.addCardHand(deck.dealCard());
				playersHand.addCardHand(deck.dealCard());
				dealersHand.addCardHand(deck.dealCard());
				
				System.out.println("### DEAL CARDS ###");
				
				// Print dealers cards
				System.out.print("DEALER'S HAND:			");		
				dealersHand.printCards();
				System.out.println("\n");
				
				// Print players cards
				System.out.print(playersHand.getUserName() + "'s HAND:		   	 ");
				playersHand.printCards();
				System.out.println("\n");
				
				playerFinish = false; // set player flag to false
				dealerFinish = false; // set dealer flag to false
				int hitOrHold = 0;
				
				/**
				 *	Players turn
				 */
				while(playerFinish == false)
				{
					System.out.print("(1) Hit (2) Hold >> ");
					hitOrHold = sc.nextInt();
					System.out.println();
					
					// player hits
					if(hitOrHold == 1)
					{
						// add card, store if bust or not
						playerFinish = !playersHand.addCardHand(deck.dealCard());
						playersHand.printCards();
						System.out.println();
					}
					
					// player holds
					else
					{
						System.out.print("<< " + playersHand.getUserName() + " STAYS >>");
						System.out.println("\n");
						playerFinish = true;
					}
				}
				
				/**
				 *	Dealers turn
				 */
				while(dealerFinish == false)
				{
					// print dealers cards after player finishes
					System.out.print("DEALER'S HAND:			");	
					dealersHand.printCards();
					System.out.println();
					
					// dealer hits if less than 17
					if(playersHand.handSum() > 21)
					{
						System.out.print("<< DEALER STAYS >>");
						System.out.println("\n");
						dealerFinish = true;
					}
					
					else if(dealersHand.handSum() < 17)
					{
						System.out.println();
						System.out.println("<< DEALER TAKES HIT >>");
						dealerFinish = !dealersHand.addCardHand(deck.dealCard());
						dealersHand.printCards();
						System.out.println();
						System.out.println();
					}	
					
					// dealer hits if card below 17 and players hand between 17 and 20
					else if(dealersHand.handSum() >= 17 && dealersHand.handSum() <= 20 && playersHand.handSum() >= 17 && playersHand.handSum() <= 20)
					{
						System.out.println();
						System.out.println("<< DEALER TAKES HIT >>");
						dealerFinish = !dealersHand.addCardHand(deck.dealCard());
						dealersHand.printCards();
						System.out.println();
						System.out.println();
					}
					
					// dealer holds
					else
					{
						System.out.print("<< DEALER STAYS >>");
						System.out.println("\n");
						dealerFinish = true;
					}
				}
						
				// display the hands of player
				System.out.print(playersHand.getUserName() + "'s HAND:			");
				playersHand.printCards();
				System.out.println();
				
				// display the hand of the dealer
				System.out.print("DEALER'S HAND:			");	
				dealersHand.printCards();
				System.out.println();
				
				// sums for player and dealer
				int playerSum = playersHand.handSum();
				int dealersSum = dealersHand.handSum();
				
				// display if dealer busts
				if(dealersSum > 21)
				{
					System.out.println();
					System.out.println("DEALER BUSTS!");
				}
				
				// display if player busts
				if(playerSum > 21)
				{
					System.out.println();
					System.out.println(playersHand.getUserName() + " BUSTS!");
				}
				
				// if player wins, add winnings, print winnings
				if(dealersSum > 21 || playerSum > dealersSum && playerSum <= 21)
				{
					// display total values for player and dealer
					System.out.println();
					System.out.println(playersHand.getUserName() + ": " + playerSum);
					System.out.println("DEALER: " + dealersSum);
					
					// display win message, add winnings
					System.out.println(playersHand.getUserName() + " WINS!");
					cash += wagerCash;
					playersHand.setCash(cash); // set the players cash total
					
					// display cash won
					System.out.println(playersHand.getUserName() + " WINS $" + wagerCash + " IN GAME " + playersHand.getGameNumber());  
					
					// add to total
					totalWinnings += wagerCash;
					
					// increase win count
					totalWins++;
				}
				
				// dealer wins, subtract winnings, display loss message
				else
				{
					// display total values for player and dealer
					System.out.println();
					System.out.println(playersHand.getUserName() + ": " + playerSum);
					System.out.println("DEALER: " + dealersSum);
					
					// display loss message, subtract winnings
					System.out.println("DEALER WINS!");
					cash -= wagerCash;
					playersHand.setCash(cash); // set the players cash total
					
					// display cash lost
					System.out.println(playersHand.getUserName() + " LOSES $" + wagerCash + " IN GAME " + playersHand.getGameNumber());
					
					// increase loss count
					totalLosses++;
				}
				
				totalGames++;
				System.out.println("************************* END GAME " + playersHand.getGameNumber() + " ******************************");
				break;
			case 2:
				// display total cash available to player
				System.out.println("AVAILABLE CASH: $" + playersHand.getCash());
				break;		
			case 3:
				// close scanner
				sc.close();
				
				// display game summary and wager summary
				System.out.println("GAME  SUMMARY: Total Games (" + totalGames + ") / Wins (" + totalWins + ") / Losses (" + totalLosses + ")");
				System.out.println("WAGER SUMMARY: $" + totalWinnings + " won");
				break;
			}
		}
	}
}
