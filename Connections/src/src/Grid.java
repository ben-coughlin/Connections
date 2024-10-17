package src;

import java.io.IOException;
import java.util.ArrayList;

public class Grid {
	
	
	public static String[][] wordSpaces = new String[4][4]; 
	
	public static void createGrid()
	{
		
		
		int rCount = 0;
		int cCount = 0;
		
		try {
			fillWS(wordSpaces);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String formattedGridBar = formatGrid(wordSpaces);
		
		printGrid(formattedGridBar);
	}
	
	public static void printGrid(String formattedGridBar) 
	{
		System.out.println("+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+\r\n"
				+ "| " + wordSpaces[0][0] + " | " + wordSpaces[0][1] + " |  " + wordSpaces[0][2] + " |  " + wordSpaces[0][3] + " |\r\n"
				+ "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+\r\n"
				+ "| " + wordSpaces[1][0] + " | " + wordSpaces[1][1] + " | " + wordSpaces[1][2] + "  | " + wordSpaces[1][3] + "  |\r\n"
				+ "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+\r\n"
				+ "| " + wordSpaces[2][0] + " | " + wordSpaces[2][1] + " | " + wordSpaces[2][2] + "  | " + wordSpaces[2][3] + "  |\r\n"
				+ "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+\r\n"
				+ "| " + wordSpaces[3][0] + " | " + wordSpaces[3][1] + " | " + wordSpaces[3][2] + "  | " + wordSpaces[3][3] + "  |\r\n"
				+ "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+" + formattedGridBar + "+");
	}
	
	public static String formatGrid(String[][] wordSpaces)
	{
		String formattedGridBar = "";
		int longestWordLength = Integer.MIN_VALUE;
		
		
		for(int r = 0; r < wordSpaces.length; r++)
		{
			for(int c = 0; c < wordSpaces[1].length; c++)
			{
				if(wordSpaces[r][c].length() > longestWordLength)
					{
						longestWordLength = wordSpaces[r][c].length();
					}
				
			}
		}
		
		// adds a little bit of spacing so the longest word isn't cramped
		
		
		
		for(int i = 0; i < longestWordLength; i++)
		{
			formattedGridBar += "-";
		}
		
		//centerWords(formattedGridBar);
		
		return formattedGridBar;
	}
	
	
	
	public static void fillWS(String[][] ws) throws IOException
	{
		
		ArrayList<Word> wordList = ReadWordlist.readFile();
		int rCount = 0;
		int cCount = 0;
		int wlCount = 0;
		
		
		//printArrayList(wordList);
		
		for(int r = 0; r < ws.length; r++)
		{
			for(int c = 0; c < ws[0].length; c++)
			{
				ws[rCount][cCount] = wordList.get(wlCount).getWord();
				
				cCount++;
				wlCount++;
				
				//used for debugging 10/3
//				System.out.println("r:"+rCount);
//				System.out.println("c:"+cCount);
//				System.out.println("wl:"+wlCount); 
				
			}
			
			cCount = 0;
			rCount++;
		}
		
		
		ShuffleBoard.shuffle(ws);
		
	}
	
	public static void printMatrix(String[][] ws)
	{
		for(int r = 0; r < ws.length; r++)
			{
				for(int c = 0; c < ws[0].length; c++)
				{
					System.out.println(ws[r][c]);
					
				}
				
			}
	}
	public static void printArrayList(ArrayList<Word> al)
	{
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i).getGroup());
			System.out.println(al.get(i).getDifficulty());
			System.out.println(al.get(i).getWord());
		}
	}
	
	
	}
	
	
	

