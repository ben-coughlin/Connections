package src;

import java.util.Random;

public class ShuffleBoard {

	static String[] guessedCategoryWords = new String[4];

	public static void shuffle(String[][] a) {
		Random random = new Random();

		for (int i = a.length - 1; i > 0; i--) {
			for (int j = a[i].length - 1; j > 0; j--) {
				int m = random.nextInt(i + 1);
				int n = random.nextInt(j + 1);

				String temp = a[i][j];
				a[i][j] = a[m][n];
				a[m][n] = temp;
			}
		}
	}
	public static void clearGuessFormatting()
	{
		
		int guessedCategoryIndex = 0;
		for(int r = 0; r < Grid.wordSpaces.length; r++)
		{
			for(int c = 0; c < Grid.wordSpaces[0].length; c++)
			{
				String word = Grid.wordSpaces[r][c];
				
				//this removes the <> around the guess
				if(word.contains("<"))
				{
					word = word.substring(1, word.length() - 1);
					Grid.wordSpaces[r][c] = word;
					guessedCategoryWords[guessedCategoryIndex] = word;
					guessedCategoryIndex++;
				}
				
				
			}
			
		}
		
		
		
		
	}
	public static void sortBoardWithCategories()
	{
		
		//this should only run when a category is guessed CORRECTLY
		
		String[] category = guessedCategoryWords;
		
		for(int i = 0; i < category.length; i++)
		{
			System.out.println(category[i]);
		}
		int categoryIndex = 0;
		
		for(int r = 0; r < Grid.wordSpaces.length; r++)
		{
			for(int c = 0; c < Grid.wordSpaces[0].length; c++)
			{
				
				if((Grid.wordSpaces[r][c].equals(category[categoryIndex])))
				{
					
					Grid.wordSpaces[r][c] = "balls";
					categoryIndex++;
				}

				
			}
			
		}
		
		
	}
	
	

}
