package src;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class ReadWordlist {
	
	public static ArrayList<Word> wordList = new ArrayList<Word>();
	
	public static ArrayList<Word> readFile() throws IOException
	{
		 Scanner fileScn = new Scanner(new File("Wordlist.txt"));
	     
	      	
	      String rawWord = fileScn.nextLine();
	      
	      System.out.println(rawWord);
	      
	      //add configurable group??
	      //String groupIndex = firstGroup.substring(0, 1);
	      //String groupIndex = "A";
	      int count = 0;
	      //this absolute MESS of parentheses ensures that this loop only goes through one group - eg "a"
	      while(count <= 16)
	      {
	    	  for(int i = 0; i < rawWord.substring(4).length(); i++)
		      {
		    	  String line = fileScn.nextLine();
		    	  String[] wordInfo = line.split(" ");
		    	  
		    	  Word test = new Word(wordInfo[0], Integer.parseInt(wordInfo[1]), wordInfo[2]);
		    	 System.out.println(test.getWord());
		    	  wordList.add(test);
		      }
	    	  count++;
	      }
		return wordList;
	      
	      
	      
	}
}
