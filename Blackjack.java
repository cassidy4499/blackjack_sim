package blackjack_sim;

import java.util.Scanner;
import java.util.Random;

public class Blackjack {
  public static void main(String[] args) {
  	System.out.println("Welcome to Blackjack!");
    int balance = 100;
    String playagain;
 
    do {	  	
  	/*place your bet*/
  	Scanner scanbet = new Scanner(System.in);
    System.out.println("You have "+balance+". Place your bet ($): ");
    int bet = scanbet.nextInt();
  	
    /*deal first cards - 2 each*/
    Random random = new Random();
	int dealercards = random.nextInt(13) + 1;
	System.out.println("One of dealer's cards is: "+dealercards);
    Random random1 = new Random();
	dealercards += random1.nextInt(13) + 1;
    
    Random random2 = new Random();
	int playercards = random2.nextInt(13) + 1;
    Random random3 = new Random();
	playercards += random3.nextInt(13) + 1;
	System.out.println("Your total: "+playercards);
	
	while (playercards < 21) {
			    
	    /*ask player for move*/
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter an action (Options: Hit, Stand): ");
	    String firstaction = in.nextLine();
	    
	    /*prepare next card*/
	   	Random random4 = new Random();
	    
	    /*execute move*/
	   	/*if hit*/
	    if (firstaction.equalsIgnoreCase("hit")){
			playercards += random4.nextInt(13) + 1;
			System.out.println(playercards);
	    	}
	    /*if stand*/
	    else if (firstaction.equalsIgnoreCase("stand")) {
			{
	        if (playercards > dealercards) {
	    		System.out.println("You won!");
	        	balance = balance + bet;
	        }
	    	else if (playercards == dealercards)
	    		System.out.println("Push");
	    	else if (playercards < dealercards && dealercards <= 21) {
	    		System.out.println("You lose.");
	    		balance = balance - bet;
	    	}
	    	else if (playercards < dealercards && dealercards > 21) {
	    		System.out.println("Dealer busts, you win!");
	    		balance = balance + bet;
	    	}
	        }
			break;
			}
	    /*if other*/
	    else {
	    	System.out.println("Invalid move.");
	    	}
		}
	/*BJ or bust*/
	if (playercards > 21) {
 		System.out.println("Bust");
 		balance = balance - bet;
	}
	else if (playercards == 21) {
 		System.out.println("Black jack!");
 		balance = balance + bet;
	}
	/*results*/
	System.out.println("Dealer's cards: "+dealercards);
    Scanner again = new Scanner(System.in);
    System.out.println("Play again? (Y/N): ");
    playagain = again.nextLine();  
	System.out.println("");
   }
  while (playagain.equalsIgnoreCase("y"));
  }

	
/*to do: double, split, insurance
 * prevent bust on first deal
 * allow for repetition*/
    
	/*if (playercards % 2 == 0) {
		Scanner splitter = new Scanner(System.in);
	    System.out.println("Split? (Y/N): ");
	    String splitdecision = splitter.nextLine();
	    if (splitdecision.equalsIgnoreCase("y")){
			playercards = playercards/2;
			int playercards2 = playercards;
	    	}
	    else if (splitdecision.equalsIgnoreCase("n")) {
	    	continue;
	    }
	}
	*/

 }
