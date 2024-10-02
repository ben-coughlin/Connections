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
	     
	  		System.out.println("welcome! choose wordset a, b, or c!");
	  		Scanner wsScan = new Scanner(System.in);
	  		
	  		String wordSet =  wsScan.nextLine().toUpperCase();
	  	
	      while(wordSet.equals(rawWord.substring(0, 1)))
	      {
	    	  rawWord = fileScn.nextLine();
	    	  String[] wordInfo = rawWord.split(" ");
	    	  
	    	  Word word = new Word(wordInfo[0], Integer.parseInt(wordInfo[1]), wordInfo[2]);
	    	  
	    	  wordList.add(word);
	    	 
	      }
	     
		return wordList;
	      
	      
	      
	}
}
