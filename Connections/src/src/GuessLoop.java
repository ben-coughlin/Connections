package src;

import java.util.Scanner;

public class GuessLoop {

	
	static int[] difficulties = new int[4];
	static int diffIndex = 0;
	
	
	public static void guessLoop()
	{
		int guessedSpace = 0;
		int numGuessesRemaining = 4;
		
		
		while(guessedSpace < 4)
		{

			highlightGuesses(Grid.wordSpaces);
			Grid.printGrid(Grid.formatGrid(Grid.wordSpaces));
			guessedSpace++;
		}
		printNumGuessesLeft(checkForCorrectCategory(), numGuessesRemaining);
	}
	
	
	
	public static void printNumGuessesLeft(boolean wasGuessCorrect, int numGuessesRemaining)
	{
		String guessIcon = " * ";
		if(!wasGuessCorrect)
		{
			numGuessesRemaining--;
			System.out.print("Guesses Remaining: ");
			for(int i = 0; i < numGuessesRemaining; i++)
			{
				System.out.print(guessIcon);
			}
		}
	}



	public static String getGuess()
	{
		Scanner guessScn = new Scanner(System.in);
		String guess = "";
		
		
		System.out.println("Enter a one-word guess");

		guess =  guessScn.nextLine();
		
		return guess;
	}
	


	public static void highlightGuesses(String[][] ws)
	{
		
		//this works 10/7
		
		String guess = getGuess().toUpperCase();
		
		
		
		for(int r = 0; r < ws.length; r++)
		{
			
			for(int c = 0; c < ws[0].length; c++)
			{
				
				if(guess.equals(ws[r][c]))
				{
					
					Grid.wordSpaces[r][c] = "‹"+ ws[r][c] + "›";
					
					int difficulty = getDifficultyOfWord(guess);
					System.out.println(diffIndex + " " + difficulty);
					storeDifficulties(difficulty, difficulties, diffIndex);
					diffIndex++;
				}

			}

		}
	
		
	}
	
	
	
	public static boolean checkForCorrectCategory()
	{
		
		
		boolean isCategoryEqual = false;
			//this then compares the array values to each other, and returns true if all values are equal (all guesses are from the same category)
		for (int i = 0; i < difficulties.length; i++) 
		{
		    for (int k = 0; k < difficulties.length; k++) 
		    {
		        if (difficulties[i] != difficulties[k]) 
		        {
		        	//this runs if the difficulties are different
		            //System.out.println(difficulties[i] + " " + difficulties[k]); //debugging
		            isCategoryEqual = false;
		            break;
		        }
		        else
		        {
		        	isCategoryEqual = true;
		        	
		        	
		        }
		    }
		}
		
		return isCategoryEqual;

			
	}
	public static int getDifficultyOfWord(String guess)
	{
		int difficulty = 0;
		
		for(int i = 0; i <  ReadWordlist.wordList.size(); i++)
		{
			if((ReadWordlist.wordList.get(i).getWord()).equalsIgnoreCase(guess))
			{
				difficulty = ReadWordlist.wordList.get(i).getDifficulty();
			}
		}
		
		return difficulty;
	}
	public static void storeDifficulties(int difficulty, int[] difficulties, int diffIndex)
	{
		difficulties[diffIndex] = difficulty;
		
		
	}

}
