package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShuffleBoard
	{

		static int numCategoriesGuessed = 0;
		static int lineIndex = 0;
		public static void shuffle(String[][] a)
			{
				Random random = new Random();

				for (int i = a.length - 1; i > 0; i--)
					{
						for (int j = a[i].length - 1; j > 0; j--)
							{
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

				for (int r = 0; r < Grid.wordSpaces.length; r++)
					{
						for (int c = 0; c < Grid.wordSpaces[0].length; c++)
							{
								String word = Grid.wordSpaces[r][c];

								// this removes the <> around the guess
								if (word.contains("<"))
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
										// this runs if the difficulties are different

										break;
									} else
									{
										// this runs if difficulties are the same
										guessedCategory = difficulties[i];

									}
							}
					}
				return guessedCategory;

			}

		public static void sortCorrectCategories()
			{

				// this should only run when a category is guessed CORRECTLY

				ArrayList<Word> sortedWL = new ArrayList<Word>();

				for (int i = 0; i < ReadWordlist.wordList.size(); i++)
					{
						sortedWL.add(ReadWordlist.wordList.get(i));
					}

				Collections.sort(sortedWL, new CategorySorter());
				numCategoriesGuessed++;
				shuffleBoardWithCategories(sortedWL);

			}

		public static void shuffleBoardWithCategories(ArrayList<Word> swl)
			{
				int index = 0;
				int guessedCategory = findCorrectCategories();
				String[][] sortedWordSpaces = new String[4][4];
				

				for (int r = 0; r < Grid.wordSpaces.length; r++)
					{
						for (int c = 0; c < Grid.wordSpaces[0].length; c++)
							{

								// this should fill the board with SORTED words
								Grid.wordSpaces[r][c] = swl.get(index).getWord();
								// System.out.println(Grid.wordSpaces[r][c] + swl.get(index).getDifficulty());
								// //debugging
								index++;

							}

					}
				// Grid.printGrid(Grid.formatGrid(Grid.wordSpaces));

				for (int r = 0; r < Grid.wordSpaces.length; r++)
					{
						for (int c = 0; c < Grid.wordSpaces[0].length; c++)
							{
								sortedWordSpaces[r][c] = Grid.wordSpaces[r][c];
								
								// System.out.println(sortedWordSpaces[r][c]);
								if (lineIndex != r)
									{
										// if the guessed category is NOT this row, do nothing
										Grid.wordSpaces[r][c] = sortedWordSpaces[r][c];
									}

								else
									{

										// guessedcategory -> the line that was guessed

										// this moves the guessed categories to the top of the board
										String temp = Grid.wordSpaces[lineIndex][c]; // 1
										
										Grid.wordSpaces[lineIndex][c] = Grid.wordSpaces[guessedCategory - 1][c];
										Grid.wordSpaces[guessedCategory - 1][c] = temp;

									}
								if (r >  numCategoriesGuessed - 1)
									{
										// DONT EVEN THINK ABOUT TOUCHING THIS FOR THE LOVE OF CHRIST
										// sorts the unguessed words
										Random rand = new Random();

										int randC = rand.nextInt(c + 1);
										int randR = rand.nextInt(r + 1);
										randR = clip(randR, numCategoriesGuessed, 3);
										
										String t = Grid.wordSpaces[r][c];
										Grid.wordSpaces[r][c] = Grid.wordSpaces[randR][randC];
										Grid.wordSpaces[randR][randC] = t;
									}

							}

					}
				lineIndex++;
				formatGuessedCategories(numCategoriesGuessed);

			}

		public static void formatGuessedCategories(int ncg)
		{
			
			String categoryIndicator = "";
			while(ncg > 0)
				{
					//adds a number to show a category
					switch(ncg)
					{
					case 1:
						{
							categoryIndicator = "₁";
							break;
						}
					case 2:
						{
							categoryIndicator = "₂";
							break;
						}
					case 3:
						{
							categoryIndicator = "₃";
							break;
						}
					case 4:
						{
							categoryIndicator = "₄";
							break;
						}
					}
					for(int r = 0; r < Grid.wordSpaces.length; r++)
					{
						for(int c = 0; c < Grid.wordSpaces[0].length; c++)
						{
							
							if(r == ncg - 1)
							{
								//this should only run if the row has been guessed and sorted
								Grid.wordSpaces[r][c] = categoryIndicator + Grid.wordSpaces[r][c] + categoryIndicator;
							}
							
						}
						
					}
					ncg--;
				}
			
		}

		public static int clip(int value, int min, int max)
			{
				// this method is used to ensure that the random row values don't encroach on
				// the already-sorted words
				// the sdk we use for robotics has a method that does this and its really useful
				return Math.max(min, Math.min(value, max));
			}

	}
