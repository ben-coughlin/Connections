package src;

import java.util.Iterator;

public class Grid {
	
	public static void createGrid()
	{
		String[][] wordSpaces = new String[4][4];
		String formattedGridBar = formatGrid(wordSpaces);
		
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
		int averageWordLength = 0;
		int counter = 0;
		
		for(int r = 0; r < wordSpaces.length; r++)
		{
			for(int c = 0; c < wordSpaces[1].length; c++)
			{
				averageWordLength += wordSpaces[r][c].length();
				counter++;
			}
		}
		
		averageWordLength /= counter;
		averageWordLength += 2;
		
		for(int i = 0; i < averageWordLength; i++)
		{
			formattedGridBar += "-";
		}
		return " + formattedGridBar + ";
	}
	
	public static void fillWordList(String[][] ws)
	{
		
	}
}
