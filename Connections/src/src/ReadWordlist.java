package src;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class ReadWordlist {
	
	public static ArrayList<Word> wordList = new ArrayList<Word>();
	
	public static void readFile() throws IOException
	{
		 Scanner fileScn = new Scanner(new File( "Wordlist.txt" ));
	      DecimalFormat df = new DecimalFormat("0.00");
	      
	      	
	      String firstGroup = fileScn.nextLine();
	      String groupIndex = firstGroup.substring(0, 1);
	      
	      //this absolute MESS of parentheses ensures that this loop only goes through one group - eg "a"
	      while(groupIndex.equals(((fileScn.nextLine()).substring(0, 1))))
	      {
	    	  for(int i = 0; i < firstGroup.substring(4).length(); i++)
		      {
		    	  String line = fileScn.nextLine();
		    	  String[] wordInfo = line.split(" ");
		    	  
		    	  Word test = new Word(wordInfo[0], Integer.parseInt(wordInfo[1]), wordInfo[2]);
		    	 
		    	  
		      }
	      }
	      
	      
	      
	}
}
