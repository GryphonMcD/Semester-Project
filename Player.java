package semesterProjectPackage;

public class Player {
	
	private String playerName;
	private int playerScore;
	private int dieOne;
	private int dieTwo;
	private boolean errorHasOccured;
	
	/*
	 * Constructor
	 */
	public Player() {
		
		this.playerName = "";
		this.playerScore = 0;
		
	}
	
	/*
	 * This method rests the player in case of a restart
	 */
	public void resetPlayer() {
		
		this.playerScore = 0;
		this.dieOne = 0;
		this.dieTwo = 0;
	}
	
	/*
	 * Sets the name of a player for later use in beginGame and welcome methods
	 */
	public void setName(String playerName) {
		
		this.playerName = playerName;
	}
	
	/*
	 * Returns the name of a player
	 * Primarily used in the welcome method and to denote who is rolling during the game
	 */
	public String getName() {
		
		return this.playerName;
	}
	
	/*
	 * Returns player score for win condition testing
	 */
	public int getPlayerScore() {
		
		return this.playerScore;
	}
	
	/*
	 * Adds and keeps track of the score. This value is later used to check for win condition
	 * Input: chosenRole - This variable represents....
	 */
	public int addToScore(int chosenRoll) {
		
		this.playerScore =+ chosenRoll;
		return this.playerScore;
	}
	
	public void resetScore(int resetTotal) {
		
		this.playerScore = resetTotal;
	}
	
	////////////////
	
	/*
	 * Gets a random number from 1-6 and returns the values. The rolls can then be chosen by the [insert script] method
	 */
	public int rollDieOne() {	
		
		//TODO: Test method

		this.dieOne = (int) ((Math.random()*6) + 1);
		return this.dieOne;
	}
	
	/*
	 * Rolls a random number from 1-6 and returns the values. The rolls can then be chosen by the [insert script] method
	 */
	public int rollDieTwo() {
		
	
		
		this.dieTwo = (int) ((Math.random()*6) + 1);
		return this.dieTwo;
	}
	////////////////
	
	public int getDieOne() {
		
		return this.dieOne;
	}
	
	public int getDieTwo() {
		
		return this.dieTwo;
	}
	
	
	/*
	 * This method checks the player's selection and adds the corresponding amount to their score
	 * This method throws an error if the player inputs an incorrect selection
	 */
	public void chooseRoll(String dieSelection) {

		
		this.errorHasOccured = false;
		
		dieSelection = dieSelection.toLowerCase();
		
		//
		if (dieSelection.equals("both") || dieSelection.equals("b")) {
			this.playerScore = this.playerScore + this.dieOne + this.dieTwo;
			System.out.println("You chose to add both dice.");
		}
		else if (dieSelection.equals("first") || dieSelection.equals("f")) {
			this.playerScore += this.dieOne;
			System.out.println("You chose to add the first die.");
		}
		else if (dieSelection.equals("second") || dieSelection.equals("s")) {
			this.playerScore += this.dieTwo;
			System.out.println("You chose to add the second die.");
		}
		else {
			//Error message for an incorrect input
			System.out.println("Error you have input an incorrect selection. Please try again.");
			this.errorHasOccured = true;
		}
		
	}
	
	public boolean getErrorHasOccured() {
		
		return this.errorHasOccured;
	}
	
	public void getASCIIDie(int dieRoll){
		
		/*
		 *  A series of multidimensional arrays used for die rolls 1 - 6
		 */
		String[][] dieOne = {
				
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
				{ "|", " ", " ", " ", " ", " ", "|"},
				{ "|", " ", " ", "*", " ", " ", "|"},
				{ "|", " ", " ", " ", " ", " ", "|"},
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
		};
		
		String[][] dieTwo = {
				
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
				{ "|", "*", " ", " ", " ", " ", "|"},
				{ "|", " ", " ", " ", " ", " ", "|"},
				{ "|", " ", " ", " ", " ", "*", "|"},
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
		};

		String[][] dieThree = {
				
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
				{ "|", "*", " ", " ", " ", " ", "|"},
				{ "|", " ", " ", "*", " ", " ", "|"},
				{ "|", " ", " ", " ", " ", "*", "|"},
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
		};
		
		String[][] dieFour = {
				
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
				{ "|", " ", "*", " ", "*", " ", "|"},
				{ "|", " ", " ", " ", " ", " ", "|"},
				{ "|", " ", "*", " ", "*", " ", "|"},
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
		};

		String[][] dieFive = {
		
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
				{ "|", "*", " ", " ", " ", "*", "|"},
				{ "|", " ", " ", "*", " ", " ", "|"},
				{ "|", "*", " ", " ", " ", "*", "|"},
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
		};

		String[][] dieSix = {
		
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
				{ "|", " ", "*", " ", "*", " ", "|"},
				{ "|", " ", "*", " ", "*", " ", "|"},
				{ "|", " ", "*", " ", "*", " ", "|"},
				{ "+" , "-" , "-" , "-", "-", "-", "+" },
		};
		
		/*
		 *  Checks the die roll against possible outcomes, then prints a corresponding ASCII die to the roll
		 */
		switch(dieRoll) {
		
			case 1: for (int row = 0; row < dieOne.length; row++) {
						for (int collumn = 0; collumn < dieOne[row].length; collumn++) {
					
						System.out.print(dieOne[row][collumn] + " ");
						}
						System.out.println("");
					} break;
				
			case 2: for (int row = 0; row < dieTwo.length; row++) {
						for (int collumn = 0; collumn < dieTwo[row].length; collumn++) {
				
							System.out.print(dieTwo[row][collumn] + " ");
						}
						System.out.println("");
					} break;
			
			case 3: for (int row = 0; row < dieThree.length; row++) {
						for (int collumn = 0; collumn < dieThree[row].length; collumn++) {
				
							System.out.print(dieThree[row][collumn] + " ");
						}
						System.out.println("");
					} break;		
			
			case 4: for (int row = 0; row < dieFour.length; row++) {
						for (int collumn = 0; collumn < dieFour[row].length; collumn++) {
				
							System.out.print(dieFour[row][collumn] + " ");
						}
						System.out.println("");
					} break;	
			
			case 5: for (int row = 0; row < dieFive.length; row++) {
						for (int collumn = 0; collumn < dieFive[row].length; collumn++) {
				
							System.out.print(dieFive[row][collumn] + " ");
						}
						System.out.println("");
					} break;
			
			case 6: for (int row = 0; row < dieSix.length; row++) {
						for (int collumn = 0; collumn < dieSix[row].length; collumn++) {
				
							System.out.print(dieSix[row][collumn] + " ");
						}
						System.out.println("");
					} break;	
		
		}	
	}
}
