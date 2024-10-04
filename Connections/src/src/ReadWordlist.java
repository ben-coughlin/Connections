package src;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadWordlist {

	public static ArrayList<Word> wordList = new ArrayList<Word>();

	public static void fillWordList(String rawWord, String wordSet, Scanner fileScn)
	{
		while(wordSet.equals(rawWord.substring(0, 1)))
		{
			rawWord = fileScn.nextLine();
			String[] wordInfo = rawWord.split(" ");

			Word word = new Word(wordInfo[0], Integer.parseInt(wordInfo[1]), wordInfo[2]);

			wordList.add(word);

		}
		
	}
	
	public static void findCorrectIndex(String rawWord, String wordSet, Scanner fileScn) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("Wordlist.txt")));
		String line;
		
		
		while (((line = br.readLine()) != null))
		{
			
			while(line.substring(0, 1).equals(wordSet))
			{
				
				//System.out.println(line);
				String[] wordInfo = line.split(" ");

				Word word = new Word(wordInfo[0], Integer.parseInt(wordInfo[1]), wordInfo[2]);

				wordList.add(word);
				
				line = br.readLine();
				
				if(line == null)
				{
					return;
				}
			}
		}
		br.close();
		
	}
	

	public static ArrayList<Word> readFile() throws IOException
	{
		Scanner fileScn = new Scanner(new File("Wordlist.txt"));


		String rawWord = fileScn.nextLine();

		//System.out.println(rawWord); debugging

		System.out.println("welcome! choose wordset a, b, or c!");
		Scanner wsScan = new Scanner(System.in);

		String wordSet =  wsScan.nextLine().toUpperCase();
		
		switch(wordSet)
		{
			case "A":
			{
				//wordset a needs no extra - first lines
				fillWordList(rawWord, wordSet, fileScn);
				break;
			}
			//b and c, though, take more work
			case "B":
			{
				findCorrectIndex(wordSet, wordSet, wsScan);
				break;
			}
			case "C":
			{
				findCorrectIndex(wordSet, wordSet, wsScan);
				break;
			}
		}
		
		return wordList;



	}
}
