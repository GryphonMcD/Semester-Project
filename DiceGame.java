package semesterProjectPackage;

import java.io.Console;
import java.util.Scanner;
import java.lang.Math;

public class DiceGame {
	
	private int numberOfDice;
	private int numberOfSides;
	private int winTotal;
	private Player playerOne = new Player();
	private Player playerTwo = new Player();
	private int currentScore;
	private boolean winCondition;
	private int turnNumber;
	private boolean acceptedName;
	private String name;
	
	
	
	// TODO: add variable number of players
	public DiceGame (int numberOfDice, int numberOfSides, int winTotal) {
		
		this.numberOfDice = numberOfDice;
		
		this.numberOfSides = numberOfSides;
		
		this.winTotal = winTotal;
		
		this.turnNumber = 0;
		
		this.currentScore = 0; 

	}

	/*
	 *  Choose a wager. ASCII art of a tavern/tavern sign/sword. 14 char hilt
	 * 
	 *  The welcome method greets the players and sets the names of the players.
	 */
	public void welcome() {
		
		//TODO: Create story build up
		//TODO: Explain rules in a original way 
		
		System.out.println("            /|");
		System.out.println(" _          )( __________________");
		System.out.println("(_)////////(**)__________________/");
		System.out.println("            )(                ");
		System.out.println("            |/");
		
		Scanner input = new Scanner(System.in);
		
		// Greet the player and ask name.
		System.out.println("Hello welcome to my tavern dice game.");
		System.out.println("What is your name?");
		this.acceptedName = false;
		
		// Get first player's name and create a player object with that name.
		while ( this.acceptedName != true) {
			this.name = input.nextLine();
			if (this.name.equals("")) {
				System.out.println("Don't be shy now! What is your name?");
			}
			else {
				this.playerOne.setName(name);
				this.acceptedName = true;
			}
		}
		
		
		
		// Prints a random greeting to the player
		int randomCommentPlayerOne =(int)(Math.random()*5);
		
		//System.out.println(randomCommentPlayerOne);
		switch (randomCommentPlayerOne) {
			case 1: System.out.println("Good to see you again " + this.playerOne.getName() + "!"); break;
			case 2: System.out.println("I thought I told you to never come back " + this.playerOne.getName() + "!"); break;
			case 3: System.out.println("No more cheating " + this.playerOne.getName() + "."); break;
			case 4: System.out.println("Oh, I thought you died " + this.playerOne.getName() + "!"); break;
			case 5: System.out.println("Tell the missus hello for me " + this.playerOne.getName() + "."); break;
			case 0: System.out.println("Good to see you again " + this.playerOne.getName() + "!"); break;
		}

		
		// Get second player's name and create a player object with that name.
		System.out.println("What is your friend's name?");
		this.acceptedName = false;
		
		while ( this.acceptedName != true) {
			this.name = input.nextLine();
			if (this.name.equals("")) {
				System.out.println("Don't be shy now! What is your name?");
			}
			else {
				this.playerTwo.setName(name);
				this.acceptedName = true;
			}
		}
		
		// Prints a random greeting to the player.
		int randomCommentPlayerTwo =(int)(Math.random()*5);
		//System.out.println(randomCommentPlayerTwo);
		switch (randomCommentPlayerTwo) {
			case 1: System.out.println("Good to see you again " + this.playerTwo.getName() + "!"); break;
			case 2: System.out.println("I thought I told you to never come back " + this.playerTwo.getName() + "!"); break;
			case 3: System.out.println("No more cheating " + this.playerTwo.getName() + "."); break;
			case 4: System.out.println("Oh, I thought you died " + this.playerTwo.getName() + "!"); break;
			case 5: System.out.println("Tell the missus hello for me " + this.playerTwo.getName() + "."); break;
			case 0: System.out.println("Good to see you again " + this.playerTwo.getName() + "!"); break;
		}
		
		// Prints a random greeting to both players.
		int randomWelcome =(int)(Math.random()*10);
		switch(randomWelcome) {
			case 1: System.out.println("Regardless, greetings " + playerOne.getName() + " and " + playerTwo.getName() + "."); break;
			case 2: System.out.println("Salutations " + playerOne.getName() + " and " + playerTwo.getName() + "."); break;
			case 3: System.out.println("Welcome to the game " + playerOne.getName() + " and " + playerTwo.getName() + "."); break;
			case 4: System.out.println("Have a good game to the both of you!"); break;
			case 5: System.out.println("I wish you the best of luck in your games."); break;
			case 6: System.out.println("I'm going to be honest... I already forgot both of your names."); break;
			case 7: System.out.println("Hey boys! Say hello to our newest players: " + playerOne.getName() + " and " + playerTwo.getName()); break;
			case 8: System.out.println("Welcome to the tavern! Keep any eye on " + playerOne.getName() + " they get a bit cheaty!"); break;
			case 9: System.out.println(playerTwo.getName() + ", kick " + playerOne.getName() + "'s butt!"); break;
			case 0: System.out.println("Welcome to the game " + playerOne.getName() + " and " + playerTwo.getName() + "."); break;
		}
	
	}
	
	
	
	/*
	 *  The beginGame method starts the game and explains the rules of Dice Game.
	 */
	public void beginGame() {
		Scanner input = new Scanner(System.in);
		
		playerOne.resetPlayer();
		playerTwo.resetPlayer();
		this.turnNumber = 0;
		this.winCondition = false;
		
		
		/*
		 *  Game rules
		 */
		System.out.println("");
		System.out.println("The goal of the game is to reach a score of exactly 30.");
		System.out.println("");
		System.out.println("Each player has two dice. The players take turns rolling their dice. When a player rolls both dice, the ");
		System.out.println("player may keep the total of both dice or the face value of either die to add to that players total. A ");
		System.out.println("player MUST select either the face value of one of the dice, or the total value of both dice. If a player's ");
		System.out.println("score goes over 30, then that player's score is reset to zero and play continues until one player obtains a ");
		System.out.println("score of exactly 30. The first player to score exactly 30 is the Winner.");
	
		//Displays initial score board for the players
		//Can also help with troubleshooting scoring/initialization problems
		displayScoreBoard();
		
		
		System.out.println(playerOne.getName() + " will roll first.");
		
		System.out.println("Let the game begin!");
		System.out.println("");
		
		/*
		 *  checks at the beginning of each turn if any player one has won the game. At which point the loop and game will end
		 */
		while (winCondition != true) {
			
			//Turn counter
			this.turnNumber += 1;
			
			//Set up: allows for the player to see their score and who's turn it is
			System.out.println(playerOne.getName()+ ": " + playerOne.getPlayerScore());
			
	
			System.out.println("First die roll . Second die roll .");
			System.out.println("Type: Both or First or Second");
			
			//Calls the ASCIIDie for player one, which prints the roll as a corresponding multidimensional array
			playerOne.getASCIIDie(playerOne.rollDieOne());
			playerOne.getASCIIDie(playerOne.rollDieTwo());
			
			//Creates the total of both dice
			System.out.println("Total of the dice: " + (playerOne.getDieOne() + playerOne.getDieTwo()));
			
			//Player choice
			playerOne.chooseRoll(input.nextLine());
			
			//Incorrect input condition catch
			//The player only has one additional attempt to type the correct word
			if (playerOne.getErrorHasOccured() == true) {
				
				System.out.println("Please try again.");
				playerOne.chooseRoll(input.nextLine());
			}
			
			//Check if the player has won
			if (playerOne.getPlayerScore() == winTotal) {
				
				System.out.println(playerOne.getName() + " wins!!!");
				this.winCondition = true;
				break;
			}
			
			if (playerOne.getPlayerScore() > winTotal) {
				
				playerOne.resetScore(0);
			}
			
			//Player current score
			System.out.println("Your score is now: " + playerOne.getPlayerScore());
			
			//Break for structure in console
			System.out.println("  ");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("  ");
			
			//Set up: allows for the player to see their score and who's turn it is
			System.out.println(playerTwo.getName() + ": " + playerTwo.getPlayerScore());
			
			
			System.out.println("First die roll. Second die roll.");
			System.out.println("Type: Both, First or Second");
			
			//Calls the ASCIIDie for player two, which prints the roll as a corresponding multidimensional array
			playerTwo.getASCIIDie(playerTwo.rollDieOne());
			playerTwo.getASCIIDie(playerTwo.rollDieTwo());
			
			//Creates the total of both dice
			System.out.println("Total of the dice: " + (playerTwo.getDieOne() + playerTwo.getDieTwo()));
			
			// Player choice
			playerTwo.chooseRoll(input.nextLine());
						
			//Incorrect input condition
			if (playerTwo.getErrorHasOccured() == true) {
				System.out.println("Please try again.");
				playerTwo.chooseRoll(input.nextLine());
			}
						
			//Extra println used for correct spacing between print statements
			System.out.println(" ");
					
			//Check if the player has won
			if (playerTwo.getPlayerScore() == winTotal) {
				System.out.println("");
				System.out.println(playerTwo.getName() + " wins!!!");
				System.out.println("");
				this.winCondition = true;
				break;
			}
						
			if (playerTwo.getPlayerScore() > winTotal) {
				playerTwo.resetScore(0);
			}
			
			//Player current score
			System.out.println("Your score is now: " + playerTwo.getPlayerScore());
			
			//Print formating
			System.out.println("  ");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("  ");
			
			//Show the final player scores in the round
			displayScoreBoard();
		
		}
		//The game has ended
		System.out.println("Good game!");
		
	}
	
	/*
	 *  The displayScoreBoard method edits a multidimensional array with the scores of the players.
	 *  The score board is then displayed to the players after every round.
	 */
	public void displayScoreBoard() {
		
		System.out.println("");
		System.out.println("==================================================================================");
		System.out.println("Turn " + this.turnNumber + " score board:");
		System.out.println("----------------------------------------------------------------------------------");
		
		System.out.println(playerOne.getName() + " has a score of " + playerOne.getPlayerScore()); System.out.println("     " + playerOne.getName() + " needs " + (this.winTotal - playerOne.getPlayerScore()) + " points to win");
		System.out.println("");
		System.out.println(playerTwo.getName() + " has a score of " + playerTwo.getPlayerScore()); System.out.println("     " + playerTwo.getName() + " needs " + (this.winTotal - playerTwo.getPlayerScore()) + " points to win");
		System.out.println("");
		
		if (playerOne.getPlayerScore() > playerTwo.getPlayerScore()) {
			System.out.println(playerOne.getName() + " is in the lead!");
			
		}
		else if (playerTwo.getPlayerScore() > playerOne.getPlayerScore()) {
			System.out.println(playerTwo.getName() + " is in the lead!");
			
		}
		else if ( playerOne.getPlayerScore() == playerTwo.getPlayerScore()) {
			System.out.println("Both of you are tied for the lead");
			
		}
		
		System.out.println("==================================================================================");
		System.out.println("");
	}
	
}
