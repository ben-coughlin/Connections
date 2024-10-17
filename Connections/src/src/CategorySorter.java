package src;

import java.util.Comparator;

public  class CategorySorter implements Comparator<Word> {
	
	public int compare(Word w1, Word w2)
	{
		return w1.getDifficulty() - w2.getDifficulty();
	}
}
