package src;

import java.util.Scanner;

public class GuessLoop {

	static int numGuessesRemaining = 3;
	static int[][] categoryGuesses = new int[4][4];
	static int categoryR = 0;
	static int categoryC = 0;
	static int guessedSpace = 0;

	
	
	public static void guessLoop()
	{
		while(guessedSpace < 4)
		{
			fillCategories();
			
		}
		printNumGuessesLeft(checkForCorrectCategory());
	}
	
	
	
	public static void printNumGuessesLeft(boolean wasGuessCorrect)
	{
		String[] guessCounter = {" * ", " * ", " * ", " * "};
		if(!wasGuessCorrect)
		{
			numGuessesRemaining--;

			for(int i = 0; i < numGuessesRemaining; i++)
			{
				System.out.println(guessCounter[i]);
			}
		}
	}



	public static String getGuess()
	{
		Scanner guessScn = new Scanner(System.in);

		System.out.println("Enter a one-word guess");

		return guessScn.nextLine();

	}
	

	public static void fillCategories()
	{
		int[] guessedSpaceCoords = highlightGuesses(Grid.wordSpaces);
		categoryGuesses[categoryR][categoryC] = guessedSpaceCoords[0];

		categoryR++;
		categoryC++;
		guessedSpace++;


	}

	public static int[] highlightGuesses(String[][] ws)
	{
		String guess = GuessLoop.getGuess();
		int[] coords = new int[2];
		for(int r = 0; r < ws.length; r++)
		{
			for(int c = 0; c < ws[0].length; c++)
			{
				if(guess.equals(ws[r][c]))
				{
					ws[r][c] = "‹"+ ws[r][c] + "›";
					coords[0] = r;
					coords[1] = c;
				}

			}

		}
		return coords;
	}
	
	
	public static boolean checkForCorrectCategory()
	{
		int[] difficulty = new int[4];

		//this absolute garbage gets the difficulty of each word that was guessed and puts it in an array
			for(int r = 0; r < categoryGuesses.length; r++)
			{
				for(int c = 0; c < categoryGuesses[0].length; c++)
				{
					String word = Grid.wordSpaces[r][c];

					for(int i = 0; i < ReadWordlist.wordList.size(); i++)
					{
						if(word.equals(ReadWordlist.wordList.get(i).getWord()))
						{
						  difficulty[i] = ReadWordlist.wordList.get(i).getDifficulty();
						}
					}

				}

			}

			//this then compares the array values to each other, and returns true if all values are equal (all guesses are from the same category)
			for (int element : difficulty) {
				if(element != difficulty[0])
				{
					return false;
				}

			}

			return true;
	}

}
