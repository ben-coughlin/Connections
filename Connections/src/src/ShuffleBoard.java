package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShuffleBoard {

	 static int numCategoriesGuessed = 0;
	 
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
					
				}
				
				
			}
			
		}
		
		
	}
	
	public static int findCorrectCategories()
	{
		int[] difficulties = GuessLoop.difficulties;
		int guessedCategory = 0;

		for (int i = 0; i < difficulties.length; i++) 
		{
		    for (int k = 0; k < difficulties.length; k++) 
		    {
		        if (difficulties[i] != difficulties[k]) 
		        {
		        	//this runs if the difficulties are different
		           
		            break;
		        }
		        else
		        {
		        	//this runs if difficulties are the same
		        	guessedCategory = difficulties[i];
		        	
		        }
		    }
		}
		return guessedCategory;

	}
	public static void sortCorrectCategories()
	{
		
		//this should only run when a category is guessed CORRECTLY
		
		ArrayList<Word> sortedWL = new ArrayList<Word>();
		
		for(int i = 0; i < ReadWordlist.wordList.size(); i++)
		{
			sortedWL.add(ReadWordlist.wordList.get(i));
		}
		
		Collections.sort(sortedWL, new CategorySorter());
		numCategoriesGuessed++;
		shuffleBoardWithCategories(sortedWL);
				
		}
		public static void shuffleBoardWithCategories(ArrayList<Word>swl)
		{
			int index = 0;
			int guessedCategory = findCorrectCategories();
			String[][] sortedWordSpaces = new String[4][4];
			Random random = new Random();


			
			for(int r = 0; r < Grid.wordSpaces.length; r++)
			{
				for(int c = 0; c < Grid.wordSpaces[0].length; c++)
				{
					
					//this should fill the board with SORTED words
					Grid.wordSpaces[r][c] = swl.get(index).getWord();
					//System.out.println(Grid.wordSpaces[r][c] + swl.get(index).getDifficulty()); //debugging
					index++;
					
				}
				
			}
			//Grid.printGrid(Grid.formatGrid(Grid.wordSpaces));

			for(int r = 0; r < Grid.wordSpaces.length; r++)
			{
				for(int c = 0; c < Grid.wordSpaces[0].length; c++)
				{
					sortedWordSpaces[r][c] = Grid.wordSpaces[r][c];
					
					//System.out.println(sortedWordSpaces[r][c]);
					if(guessedCategory - 1 != r)
					{
						//if the guessed category is NOT this row, do nothing
						Grid.wordSpaces[r][c] = sortedWordSpaces[r][c];
					}
					
					else
					{
						System.out.println("true");
						//if the guessed category IS this row, something
						
						int m = random.nextInt(r + 1);
						int n = random.nextInt(c + 1);
						
						String temp = Grid.wordSpaces[numCategoriesGuessed - 1][c];
						Grid.wordSpaces[numCategoriesGuessed - 1][c] = Grid.wordSpaces[numCategoriesGuessed][m];
						Grid.wordSpaces[numCategoriesGuessed][m] = temp;
						
//						String temp = Grid.wordSpaces[0][c];
//						Grid.wordSpaces[0][c] = Grid.wordSpaces[1][c];
//						Grid.wordSpaces[1][c] = temp;
						
						

					}
					
					
				}
				
			}
			
			//shuffleUnguessed(guessedCategory);
			//Grid.printGrid(Grid.formatGrid(Grid.wordSpaces));

		}
//		public static void shuffleUnguessed(int guessedCategory)
//		{
//			Random random = new Random();
//			for (int i = Grid.wordSpaces.length - 1 - (numCategoriesGuessed); i > 0; i--) {
//				for (int j = Grid.wordSpaces[i].length - 1; j > 0; j--) {
//					int m = random.nextInt(i + 1);
//					int n = random.nextInt(j + 1);
//					if(guessedCategory - 1 != j)
//					{
//						String temp = Grid.wordSpaces[num][j];
//						Grid.wordSpaces[i][j] = Grid.wordSpaces[m][n];
//						Grid.wordSpaces[m][n] = temp;
//					}
//					
//				}
//			}
//		}
			
		
		
		
	}
	
	


