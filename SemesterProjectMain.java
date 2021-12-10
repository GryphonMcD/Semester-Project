package semesterProjectPackage;
import java.util.Scanner;

public class SemesterProjectMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean continueGame = true;
		
		//"Number of Dice, Number of Sides, Winning Total" in that order 
		//Used to create the dice game object
		DiceGame myGame = new DiceGame(2, 6, 30);
		
		//Welcome 
		myGame.welcome();
		
		System.out.println("So do you two want to play a game? Yes or No");
		
		//Checks if the the players want to play another game
		while(continueGame = true) {
			
			String playGame = input.nextLine();
			playGame = playGame.toLowerCase();
		
			if (playGame.equals("yes") || playGame.equals("y")) {
				myGame.beginGame();
				continueGame = true;
			}
			else if (playGame.equals("no") || playGame.equals("n")) {
				System.out.println("Ok suit yourself. I'll be here if you change your mind.");
				continueGame = false;
			}
			else {
				System.out.println("I said: Yes or No. How hard is that to answer. Come back later.");
				continueGame = false;
			}
			
			//Ends the game until the program is ran again manually
			if (continueGame == false) {
				break;
			}
			else {
				
				System.out.println("");
				System.out.println("Back for another round?");
				
			}
			
		}
		
		

	}
	


}
