package src;

import java.util.Random;

public class ShuffleBoard {


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
	public static String[] clearGuessFormatting()
	{
		 String[] guessedCategoryWords = new String[4];
		 
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
					System.out.println(word);
					
					guessedCategoryIndex++;
				}
				
				
			}
			
		}
		
		return guessedCategoryWords;
	}
	public static void sortBoardWithCategories()
	{
		
		//this should only run when a category is guessed CORRECTLY
		
		String[] category = clearGuessFormatting();
		String[][] wordSpaceContent = new String[4][4];
		
		int categoryIndex = 0;
		
		
		for(int r = 0; r < Grid.wordSpaces.length; r++)
		{
			for(int c = 0; c < Grid.wordSpaces[0].length; c++)
			{
//				wordSpaceContent[r][c] = Grid.wordSpaces[r][c];
//				
//				System.out.println("wsc" + wordSpaceContent[r][c]);
//				
//				if((Grid.wordSpaces[r][c].equals(category[categoryIndex])))
//				{
//					
//					Grid.wordSpaces[1][categoryIndex] = wordSpaceContent[r][c];
//					
//					categoryIndex++;
//					System.out.println("catindx"+categoryIndex);
//					
//				}
				
				System.out.println(category[categoryIndex]);
				categoryIndex++;

				
			}
			
		}
		
		
	}
	
	

}
